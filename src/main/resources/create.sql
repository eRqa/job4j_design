CREATE TABLE RULES (
                       ID SERIAL PRIMARY KEY,
                       NAME VARCHAR(255)
);

CREATE TABLE ROLES (
                      ID SERIAL PRIMARY KEY,
                      NAME VARCHAR(255)
);

CREATE TABLE ROLES_RULES (
                             ID SERIAL PRIMARY KEY,
                             ROLE_ID INT REFERENCES ROLES(ID),
                             RULE_ID INT REFERENCES RULES(ID)
);

CREATE TABLE DB_USERS (
                          ID SERIAL PRIMARY KEY,
                          NAME VARCHAR(255),
                          ROLE_ID INT REFERENCES ROLES(ID)
);

CREATE TABLE CATEGORIES (
                          ID SERIAL PRIMARY KEY,
                          NAME VARCHAR(255)
);

CREATE TABLE STATES (
                          ID SERIAL PRIMARY KEY,
                          NAME VARCHAR(255)
);

CREATE TABLE ITEMS (
                          ID SERIAL PRIMARY KEY,
                          NAME VARCHAR(255),
                          USER_ID INT REFERENCES DB_USERS(ID),
                          CATEGORY_ID INT REFERENCES CATEGORIES(ID),
                          STATE_ID INT REFERENCES STATES(ID)
);

CREATE TABLE COMMENTS (
                        ID SERIAL PRIMARY KEY,
                        TEXT VARCHAR(255),
                        ITEM_ID INT REFERENCES ITEMS(ID)
);

CREATE TABLE ATTACHES (
                        ID SERIAL PRIMARY KEY,
                        NAME VARCHAR(255),
                        DATA BYTEA,
                        ITEM_ID INT REFERENCES ITEMS(ID)
);