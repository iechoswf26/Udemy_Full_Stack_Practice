ALTER TABLE users
    ADD CONSTRAINT valid_username CHECK (
        length(username) BETWEEN 6 AND 30
            AND username ~ '^[A-Za-z0-9_-]+$'
        );

ALTER TABLE users
    ADD CONSTRAINT check_email_format CHECK (
        email ~* '^[A-Za-z0-9._+%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'
        );

ALTER TABLE users
    ADD CONSTRAINT minimum_age_17 CHECK (
        age(birth_date) >= INTERVAL '17 years'
        );