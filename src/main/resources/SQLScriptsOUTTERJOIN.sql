SELECT
    CAR.NAME,
    BODY.NAME,
    ENGINE.NAME,
    TRANSMISSION.NAME
FROM
    CAR
        LEFT JOIN BODY
                  ON CAR.BODY_ID = BODY.ID
        LEFT JOIN ENGINE
                  ON CAR.ENGINE_ID = ENGINE.ID
        LEFT JOIN TRANSMISSION
                  ON CAR.TRANSMISSION_ID = TRANSMISSION.ID

//

SELECT
    BODY.NAME
FROM
    BODY
        LEFT JOIN CAR
                  ON CAR.BODY_ID = BODY.ID
WHERE CAR.ID IS NULL

UNION

SELECT
    ENGINE.NAME
FROM
    ENGINE
        LEFT JOIN CAR
                  ON CAR.ENGINE_ID = ENGINE.ID
WHERE CAR.ID IS NULL

UNION

SELECT
    TRANSMISSION.NAME
FROM
    TRANSMISSION
        LEFT JOIN CAR
                  ON CAR.TRANSMISSION_ID = TRANSMISSION.ID
WHERE CAR.ID IS NULL