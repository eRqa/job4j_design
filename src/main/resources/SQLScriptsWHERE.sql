SELECT
    PRODUCT.NAME
FROM
    PRODUCT
WHERE PRODUCT.TYPE_ID IN (SELECT
                              TYPE.ID
                          FROM
                              TYPE
                          WHERE TYPE.NAME LIKE '%Сыр%')
//
SELECT
    PRODUCT.NAME
FROM
    PRODUCT
WHERE PRODUCT.NAME LIKE '%мороженное%'
//
SELECT
    PRODUCT.NAME
FROM
    PRODUCT
WHERE PRODUCT.EXPIRED_DATE BETWEEN '2021.02.01' AND '2021.02.28'
//
SELECT
    PRODUCT.NAME,
    PRODUCT.PRICE
FROM
    PRODUCT
WHERE PRODUCT.PRICE IN (SELECT
                            MAX(PRODUCT.PRICE)
                        FROM
                            PRODUCT)
//
SELECT
    PRODUCT.NAME,
    PRODUCT.TYPE_ID
FROM
    PRODUCT
WHERE
        PRODUCT.TYPE_ID = 2

//
SELECT
    PRODUCT.NAME
FROM
    PRODUCT
WHERE PRODUCT.TYPE_ID IN (SELECT
                              TYPE.ID
                          FROM
                              TYPE
                          WHERE TYPE.NAME LIKE '%Сыр%' OR TYPE.NAME LIKE '%Молоко%')

//
SELECT
    TYPE.NAME
FROM
    (SELECT
         PRODUCT.TYPE_ID,
         SUM(PRODUCT.COUNT) AS ALLCOUNT
     FROM
         PRODUCT
     GROUP BY
         PRODUCT.TYPE_ID) AS GroupedProducts
        INNER JOIN TYPE
                   ON GroupedProducts.TYPE_ID = TYPE.ID
WHERE
        GroupedProducts.ALLCOUNT > 11

//
SELECT
    PRODUCT.ID,
    PRODUCT.NAME,
    TYPE.NAME
FROM
    PRODUCT
        INNER JOIN TYPE
                   ON TYPE.ID = PRODUCT.TYPE_ID