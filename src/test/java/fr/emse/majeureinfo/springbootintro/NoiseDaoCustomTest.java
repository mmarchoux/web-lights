package fr.emse.majeureinfo.springbootintro;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.DeleteAll;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;
import fr.emse.majeureinfo.springbootintro.dao.Noise.NoiseDao;
import fr.emse.majeureinfo.springbootintro.model.Status;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/test.properties")
public class NoiseDaoCustomTest {

    @Autowired
    private NoiseDao noiseDao;


    @Qualifier("dataSource")
    @Autowired
    private javax.sql.DataSource dataSource;

    protected static final DbSetupTracker TRACKER = new DbSetupTracker();

    private static final Operation DELETE_ALL = DeleteAll.from("room", "noise");

    protected void dbSetup(Operation operation) {
        DbSetup setup = new DbSetup(new DataSourceDestination(dataSource),
                Operations.sequenceOf(DELETE_ALL, operation));
        TRACKER.launchIfNecessary(setup);
    }

    @Before
    public void prepare() {
        Operation noise =
                Insert.into("NOISE")
                        .withDefaultValue("status", Status.ON)
                        .columns("id", "level")
                        .values(1L, 22)
                        .build();
        dbSetup(noise);
    }

    @Test
    public void shouldFindOnNoises() {
        TRACKER.skipNextLaunch();
        Assertions.assertThat(noiseDao.findOnNoises()).hasSize(1);
    }



}
