ALTER TABLE chapter
    ADD description TEXT;

ALTER TABLE chapter
    ALTER COLUMN description SET NOT NULL;