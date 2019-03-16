CREATE TABLE bricklink_inventory (
  bl_inventory_id int(11) NOT NULL AUTO_INCREMENT,
  uuid char(32) NOT NULL,
  box_id int(11) NOT NULL,
  box_index int(11) NOT NULL,
  bl_item_number varchar(10) NOT NULL,
  inventory_id int(11) DEFAULT NULL,
  item_type varchar(20) NOT NULL,
  color_id smallint(6) DEFAULT NULL,
  color_name varchar(50) DEFAULT NULL,
  quantity smallint(6) NOT NULL,
  new_or_used varchar(1) NOT NULL,
  completeness varchar(1) NOT NULL,
  unit_price decimal(7,2) NOT NULL,
  bind_id int(11) DEFAULT NULL,
  description varchar(1024) DEFAULT NULL,
  remarks varchar(1024) DEFAULT NULL,
  bulk smallint(6) DEFAULT NULL,
  is_retain BOOLEAN NOT NULL,
  is_stock_room BOOLEAN NOT NULL,
  stock_room_id varchar(1) NOT NULL,
  date_created datetime DEFAULT NULL,
  my_cost decimal(7,2) DEFAULT NULL,
  sale_rate tinyint(4) DEFAULT NULL,
  tier_quantity1 smallint(6) DEFAULT NULL,
  tier_quantity2 smallint(6) DEFAULT NULL,
  tier_quantity3 smallint(6) DEFAULT NULL,
  tier_price1 decimal(7,2) DEFAULT NULL,
  tier_price2 decimal(7,2) DEFAULT NULL,
  tier_price3 decimal(7,2) DEFAULT NULL,
  my_weight decimal(5,2) DEFAULT NULL,
  sealed BOOLEAN NOT NULL,
  order_id int(11) DEFAULT NULL,
  fixed_price BOOLEAN DEFAULT NULL,
  for_sale BOOLEAN DEFAULT NULL,
  built_once BOOLEAN DEFAULT NULL,
  box_condition_id int(11) DEFAULT NULL,
  instructions_condition_id int(11) DEFAULT NULL,
  internal_comments varchar(1024) DEFAULT NULL,
  update_timestamp datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  last_synchronized_timestamp datetime DEFAULT NULL,
  CONSTRAINT bl_inventory_id_pk PRIMARY KEY (bl_inventory_id),
  CONSTRAINT bl_item_index_1 UNIQUE (bl_item_number),
  CONSTRAINT inventory_index_index_1 UNIQUE (box_id,box_index),
  CONSTRAINT uuid_index UNIQUE (uuid)
);

INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (1, 'M', 'Mint', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (2, 'E', 'Excellent', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (3, 'VG', 'Very Good', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (4, 'G', 'Good', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (5, 'P', 'Poor', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (6, 'NA', 'Not Applicable', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (7, 'F', 'Fair', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (8, 'MS', 'Missing', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (9, 'CC', 'Color Copy', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (10, 'BW', 'Black & White Copy', null);
INSERT INTO `condition` (condition_id, condition_code, condition_description, condition_text) VALUES (11, 'SL', 'Sealed', 'Mint in sealed box');
INSERT INTO item (item_id, item_number, item_name, number_of_pieces, issue_year, issue_location, theme_id, item_type_code, notes) VALUES (211, '6481', 'Road Works with Warning Lights', 178, 1989, 'E', 10, 'S', null);
INSERT INTO bricklink_item (item_id, bl_item_number, bl_item_id) VALUES (211, '6481-1', 5082);
INSERT INTO bricklink_inventory (uuid, box_id, box_index, bl_item_number, inventory_id, item_type, color_id, color_name, quantity, new_or_used, completeness, unit_price, bind_id, description, remarks, bulk, is_retain, is_stock_room, stock_room_id, date_created, my_cost, sale_rate, tier_quantity1, tier_quantity2, tier_quantity3, tier_price1, tier_price2, tier_price3, my_weight, sealed, order_id, fixed_price, for_sale, built_once, box_condition_id, instructions_condition_id, internal_comments, update_timestamp, last_synchronized_timestamp)
VALUES ('34ae5dfede966c39af7f1d60dd1c8a3e', 1, 1, '6481-1', null, 'SET', 0, null, 1, 'U', 'C', 0.00, null, null, null, 0, 0, 1, 'A', null, null, null, null, null, null, null, null, null, null, 0, null, 0, 1, 0, null, null, null, '2019-03-03 17:56:08', null);
commit;