SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE item;
SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE item ALTER COLUMN item_id RESTART WITH 1;