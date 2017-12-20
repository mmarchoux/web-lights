# web-lights


## Objects

### Status
**type :** enum

**values :** ON, OFF

### Light
 
| **Name**  |     id   |   level    |   status  |
| --------- | -------- | ---------  | --------- |
| **Type**  |    Long  |  Integer   |   Status  |

**methods :**
* getId()
* setId(Long id)
* getLevel()
* setLevel(Integer level)
* getStatus()
* setStatus(Status status)

### Noise
 
| **Name**  |     id   |   level    |   status  |
| --------- | -------- | ---------  | --------- |
| **Type**  |    Long  |  Integer   |   Status  |

**methods :**
* getId()
* setId(Long id)
* getLevel()
* setLevel(Integer level)
* getStatus()
* setStatus(Status status)

### Room
 
| **Name**  |     id   |   light    |   noise  |
| --------- | -------- | ---------  | -------- |
| **Type**  |    Long  |  Light     |   Noise  |

**methods :**
* getId()
* setId(Long id)
* getLight()
* setLight(Light light)
* getNoise()
* setNoise(Noise noise)
* switchLight()
* switchRinger()

## Mapping
**origin :** /api/rooms

**list of room with light on :** /list-with-on-light
**list of room with light off :** /list-with-off-light

**list of room with noise on :** /list-with-on-noise
**list of room with noise off :** /list-with-off-noise

**access to a room :** /{roomId}

**switch light :** /{roomId}/switchlight

**switch light :** /{roomId}/switchringer
