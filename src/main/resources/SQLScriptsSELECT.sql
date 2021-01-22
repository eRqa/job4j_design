SELECT
    DB_USERS.ID AS Идентификатор,
    DB_USERS.NAME AS Имя,
    ROLES.NAME AS Роль
FROM DB_USERS
         INNER JOIN ROLES
                    ON DB_USERS.ROLE_ID = ROLES.ID

SELECT
    ROLES.NAME AS RoleName,
    RULES.NAME AS RuleName
FROM ROLES
         INNER JOIN ROLES_RULES
            INNER JOIN RULES
            ON RULES.ID = ROLES_RULES.RULE_ID
        ON ROLES.ID = ROLES_RULES.ROLE_ID

SELECT
    ITEMS.NAME AS "Имя заявки",
    DB_USERS.NAME AS Исполнитель,
    STATES.NAME AS Статус,
    CATEGORIES.NAME AS Категория
FROM ITEMS
    INNER JOIN DB_USERS
    ON ITEMS.USER_ID = DB_USERS.ID
    INNER JOIN STATES
    ON ITEMS.STATE_ID = STATES.ID
    INNER JOIN CATEGORIES
    ON ITEMS.CATEGORY_ID = CATEGORIES.ID