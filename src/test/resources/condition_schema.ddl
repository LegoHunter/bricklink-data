CREATE TABLE `condition` (
  condition_id int(11) DEFAULT NULL,
  condition_code varchar(5) NOT NULL,
  condition_description varchar(50) NOT NULL,
  condition_text tinytext,
  constraint condition_id primary key (condition_id),
  CONSTRAINT condition_code_index UNIQUE (condition_code)
);
