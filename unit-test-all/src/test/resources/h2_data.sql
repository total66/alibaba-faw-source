insert into `user`(id, gmt_create, gmt_modified, name, description)
values (1, now(), now(), 'test', '测试用户'),
       (2, now(), now(), 'java', 'Java用户');

insert into `order` (id, order_no, member_id, supplier_id, product_id, product_count, product_amount_total,
                     order_amount_total, address, create_time)
values (1, 'order_no', 100, 100, 100, 100, 100.00, 100.00, 'address', now());