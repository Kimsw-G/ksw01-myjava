SELECT
    *
FROM
    EMPLOYEE E
WHERE
    E.SALARY BETWEEN (
        SELECT
            LOSAL
        FROM
            SALGRADE
        WHERE
            GRADE=1
    )
    AND (
        SELECT
            HISAL
        FROM
            SALGRADE
        WHERE
            GRADE=1
    );

INSERT INTO EMPLOYEE VALUES (
    7000,
    'BAN',
    'CLERK',
    7900,
    TO_DATE('23-1-1982', 'dd-mm-yyyy'),
    950,
    300,
    20
);