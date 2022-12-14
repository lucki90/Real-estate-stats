INSERT INTO real_estate(id, region, report_date)
VALUES (1, 'DLN_WROC_PC', '2022-08-23T21:00:00.0'),
       (2, 'DLN_POZA_WROC', '2022-08-23T21:00:00.0'),
       (3, 'SL_POL', '2022-08-23T21:00:00.0'),
       (4, 'SL_KATO', '2022-08-23T21:00:00.0'),
       (5, 'SL_PN', '2022-08-23T21:00:00.0'),
       (6, 'M_WAW_CE', '2022-08-23T21:00:00.0'),
       (7, 'M_WAW_W', '2022-08-23T21:00:00.0'),
       (8, 'M_WAW_Z', '2022-08-23T21:00:00.0'),
       (9, 'LUBL', '2022-08-23T21:00:00.0'),
       (10, 'LUBL_INNE', '2022-08-23T21:00:00.0');

INSERT INTO real_estate_data(id, real_estate_id, type, price, description, size, rooms)
VALUES (1, 1, 'terraced_house', 648502.00, 'Description nr 1', 'S', 1),
       (2, 1, 'flat', 259901.00, 'Description nr 2', 'S', 1),
       (3, 1, 'semi_detached_house', 315533.00, 'Description nr 3', 'S', 1),
       (4, 1, 'semi_detached_house', 584265.00, 'Description nr 4', 'S', 1),
       (5, 1, 'detached_house', 623662.00, 'Description nr 5', 'M', 1),
       (6, 1, 'flat', 236089.00, 'Description nr 6', 'S', 1),
       (7, 1, 'detached_house', 338108.00, 'Description nr 7', 'S', 1),
       (8, 1, 'flat', 450055.00, 'Description nr 8', 'S', 1),
       (9, 1, 'detached_house', 586203.00, 'Description nr 9', 'S', 1),
       (10, 1, 'terraced_house', 784188.00, 'Description nr 10', 'M', 1),
       (11, 1, 'detached_house', 806572.00, 'Description nr 11', 'S', 1),
       (12, 1, 'terraced_house', 49630.00, 'Description nr 12', 'S', 1),
       (13, 1, 'terraced_house', 60644.00, 'Description nr 13', 'S', 1),
       (14, 1, 'semi_detached_house', 604964.00, 'Description nr 14', 'S', 1),
       (15, 1, 'semi_detached_house', 514902.00, 'Description nr 15', 'L', 1),
       (16, 1, 'detached_house', 349835.00, 'Description nr 16', 'S', 1),
       (17, 1, 'flat', 670901.00, 'Description nr 17', 'S', 1),
       (18, 1, 'detached_house', 295444.00, 'Description nr 18', 'S', 1),
       (19, 1, 'terraced_house', 625760.00, 'Description nr 19', 'S', 1),
       (20, 2, 'detached_house', 799844.00, 'Description nr 20', 'M', 1),
       (21, 2, 'flat', 413250.00, 'Description nr 21', 'S', 1),
       (22, 2, 'flat', 847269.00, 'Description nr 22', 'S', 1),
       (23, 2, 'flat', 65758.00, 'Description nr 23', 'S', 1),
       (24, 2, 'semi_detached_house', 219470.00, 'Description nr 24', 'S', 1),
       (25, 2, 'terraced_house', 984375.00, 'Description nr 25', 'M', 1),
       (26, 2, 'semi_detached_house', 198979.00, 'Description nr 26', 'S', 1),
       (27, 2, 'detached_house', 171421.00, 'Description nr 27', 'S', 1),
       (28, 2, 'detached_house', 340733.00, 'Description nr 28', 'S', 1),
       (29, 2, 'semi_detached_house', 943528.00, 'Description nr 29', 'S', 1),
       (30, 2, 'flat', 92243.00, 'Description nr 30', 'L', 1),
       (31, 2, 'semi_detached_house', 422309.00, 'Description nr 31', 'S', 1),
       (32, 2, 'detached_house', 386261.00, 'Description nr 32', 'S', 1),
       (33, 2, 'flat', 513555.00, 'Description nr 33', 'S', 1),
       (34, 2, 'terraced_house', 598269.00, 'Description nr 34', 'S', 1),
       (35, 2, 'terraced_house', 132288.00, 'Description nr 35', 'M', 1),
       (36, 2, 'detached_house', 109912.00, 'Description nr 36', 'S', 1),
       (37, 2, 'terraced_house', 842740.00, 'Description nr 37', 'S', 1),
       (38, 2, 'flat', 420787.00, 'Description nr 38', 'S', 1),
       (39, 2, 'detached_house', 243217.00, 'Description nr 39', 'S', 1),
       (40, 3, 'semi_detached_house', 903129.00, 'Description nr 40', 'M', 2),
       (41, 3, 'detached_house', 6139.00, 'Description nr 41', 'S', 2),
       (42, 3, 'flat', 569642.00, 'Description nr 42', 'S', 2),
       (43, 3, 'flat', 544223.00, 'Description nr 43', 'S', 2),
       (44, 3, 'detached_house', 854785.00, 'Description nr 44', 'S', 2),
       (45, 3, 'flat', 462099.00, 'Description nr 45', 'L', 2),
       (46, 3, 'detached_house', 798615.00, 'Description nr 46', 'S', 2),
       (47, 3, 'semi_detached_house', 623373.00, 'Description nr 47', 'S', 2),
       (48, 3, 'detached_house', 82536.00, 'Description nr 48', 'S', 2),
       (49, 3, 'semi_detached_house', 660763.00, 'Description nr 49', 'S', 2),
       (50, 3, 'detached_house', 689607.00, 'Description nr 50', 'M', 2),
       (51, 3, 'semi_detached_house', 994992.00, 'Description nr 51', 'S', 2),
       (52, 3, 'terraced_house', 143142.00, 'Description nr 52', 'S', 2),
       (53, 3, 'terraced_house', 777364.00, 'Description nr 53', 'S', 2),
       (54, 3, 'terraced_house', 999369.00, 'Description nr 54', 'S', 2),
       (55, 3, 'flat', 657149.00, 'Description nr 55', 'M', 2),
       (56, 3, 'terraced_house', 207071.00, 'Description nr 56', 'S', 2),
       (57, 3, 'flat', 614942.00, 'Description nr 57', 'S', 2),
       (58, 3, 'detached_house', 756864.00, 'Description nr 58', 'S', 2),
       (59, 3, 'terraced_house', 806750.00, 'Description nr 59', 'S', 2),
       (60, 4, 'flat', 503210.00, 'Description nr 60', 'L', 2),
       (61, 4, 'flat', 748014.00, 'Description nr 61', 'S', 2),
       (62, 4, 'terraced_house', 923027.00, 'Description nr 62', 'S', 2),
       (63, 4, 'flat', 171539.00, 'Description nr 63', 'S', 2),
       (64, 4, 'flat', 646975.00, 'Description nr 64', 'S', 2),
       (65, 4, 'semi_detached_house', 482223.00, 'Description nr 65', 'M', 2),
       (66, 4, 'semi_detached_house', 540518.00, 'Description nr 66', 'S', 2),
       (67, 4, 'semi_detached_house', 767201.00, 'Description nr 67', 'S', 2),
       (68, 4, 'detached_house', 843836.00, 'Description nr 68', 'S', 2),
       (69, 4, 'terraced_house', 745514.00, 'Description nr 69', 'S', 2),
       (70, 4, 'detached_house', 971416.00, 'Description nr 70', 'M', 2),
       (71, 4, 'semi_detached_house', 699604.00, 'Description nr 71', 'S', 2),
       (72, 4, 'terraced_house', 134527.00, 'Description nr 72', 'S', 2),
       (73, 4, 'detached_house', 960817.00, 'Description nr 73', 'S', 2),
       (74, 4, 'terraced_house', 672348.00, 'Description nr 74', 'S', 2),
       (75, 4, 'semi_detached_house', 849626.00, 'Description nr 75', 'L', 2),
       (76, 4, 'terraced_house', 758373.00, 'Description nr 76', 'S', 2),
       (77, 4, 'flat', 499957.00, 'Description nr 77', 'S', 2),
       (78, 4, 'detached_house', 55027.00, 'Description nr 78', 'S', 2),
       (79, 4, 'flat', 210414.00, 'Description nr 79', 'S', 2),
       (80, 5, 'semi_detached_house', 205102.00, 'Description nr 80', 'M', 3),
       (81, 5, 'semi_detached_house', 793601.00, 'Description nr 81', 'S', 3),
       (82, 5, 'detached_house', 978822.00, 'Description nr 82', 'S', 3),
       (83, 5, 'terraced_house', 735130.00, 'Description nr 83', 'S', 3),
       (84, 5, 'detached_house', 448112.00, 'Description nr 84', 'S', 3),
       (85, 5, 'flat', 487818.00, 'Description nr 85', 'M', 3),
       (86, 5, 'detached_house', 801529.00, 'Description nr 86', 'S', 3),
       (87, 5, 'semi_detached_house', 264663.00, 'Description nr 87', 'S', 3),
       (88, 5, 'semi_detached_house', 934673.00, 'Description nr 88', 'S', 3),
       (89, 5, 'detached_house', 447680.00, 'Description nr 89', 'S', 3),
       (90, 5, 'semi_detached_house', 293180.00, 'Description nr 90', 'L', 3),
       (91, 5, 'flat', 604435.00, 'Description nr 91', 'S', 3),
       (92, 5, 'semi_detached_house', 62740.00, 'Description nr 92', 'S', 3),
       (93, 5, 'detached_house', 980707.00, 'Description nr 93', 'S', 3),
       (94, 5, 'semi_detached_house', 212995.00, 'Description nr 94', 'S', 3),
       (95, 5, 'flat', 693451.00, 'Description nr 95', 'M', 3),
       (96, 5, 'detached_house', 305677.00, 'Description nr 96', 'S', 3),
       (97, 5, 'terraced_house', 649566.00, 'Description nr 97', 'S', 3),
       (98, 5, 'detached_house', 232221.00, 'Description nr 98', 'S', 3),
       (99, 5, 'semi_detached_house', 145328.00, 'Description nr 99', 'S', 3),
       (100, 6, 'detached_house', 796755.00, 'Description nr 100', 'M', 3),
       (101, 6, 'terraced_house', 345086.00, 'Description nr 101', 'S', 3),
       (102, 6, 'flat', 149734.00, 'Description nr 102', 'S', 3),
       (103, 6, 'terraced_house', 701095.00, 'Description nr 103', 'S', 3),
       (104, 6, 'semi_detached_house', 923463.00, 'Description nr 104', 'S', 3),
       (105, 6, 'detached_house', 261181.00, 'Description nr 105', 'L', 3),
       (106, 6, 'detached_house', 494989.00, 'Description nr 106', 'S', 3),
       (107, 6, 'terraced_house', 108631.00, 'Description nr 107', 'S', 3),
       (108, 6, 'flat', 632391.00, 'Description nr 108', 'S', 3),
       (109, 6, 'detached_house', 812916.00, 'Description nr 109', 'S', 3),
       (110, 6, 'flat', 126425.00, 'Description nr 110', 'M', 3),
       (111, 6, 'flat', 995453.00, 'Description nr 111', 'S', 3),
       (112, 6, 'semi_detached_house', 300522.00, 'Description nr 112', 'S', 3),
       (113, 6, 'detached_house', 505976.00, 'Description nr 113', 'S', 3),
       (114, 6, 'flat', 942771.00, 'Description nr 114', 'S', 3),
       (115, 6, 'terraced_house', 715034.00, 'Description nr 115', 'M', 3),
       (116, 6, 'terraced_house', 882086.00, 'Description nr 116', 'S', 3),
       (117, 6, 'terraced_house', 734245.00, 'Description nr 117', 'S', 3),
       (118, 6, 'flat', 119931.00, 'Description nr 118', 'S', 3),
       (119, 6, 'terraced_house', 140981.00, 'Description nr 119', 'S', 3),
       (120, 7, 'semi_detached_house', 418110.00, 'Description nr 120', 'L', 4),
       (121, 7, 'semi_detached_house', 91394.00, 'Description nr 121', 'S', 4),
       (122, 7, 'flat', 136123.00, 'Description nr 122', 'S', 4),
       (123, 7, 'terraced_house', 340766.00, 'Description nr 123', 'S', 4),
       (124, 7, 'flat', 88151.00, 'Description nr 124', 'S', 4),
       (125, 7, 'flat', 446056.00, 'Description nr 125', 'M', 4),
       (126, 7, 'semi_detached_house', 632384.00, 'Description nr 126', 'S', 4),
       (127, 7, 'flat', 61.00, 'Description nr 127', 'S', 4),
       (128, 7, 'semi_detached_house', 102022.00, 'Description nr 128', 'S', 4),
       (129, 7, 'detached_house', 623240.00, 'Description nr 129', 'S', 4),
       (130, 7, 'terraced_house', 514813.00, 'Description nr 130', 'M', 4),
       (131, 7, 'flat', 340223.00, 'Description nr 131', 'S', 4),
       (132, 7, 'detached_house', 800692.00, 'Description nr 132', 'S', 4),
       (133, 7, 'terraced_house', 156439.00, 'Description nr 133', 'S', 4),
       (134, 7, 'semi_detached_house', 217992.00, 'Description nr 134', 'S', 4),
       (135, 7, 'semi_detached_house', 647638.00, 'Description nr 135', 'L', 4),
       (136, 7, 'semi_detached_house', 891152.00, 'Description nr 136', 'S', 4),
       (137, 7, 'detached_house', 337239.00, 'Description nr 137', 'S', 4),
       (138, 7, 'flat', 26216.00, 'Description nr 138', 'S', 4),
       (139, 7, 'terraced_house', 56448.00, 'Description nr 139', 'S', 4),
       (140, 8, 'semi_detached_house', 673996.00, 'Description nr 140', 'M', 4),
       (141, 8, 'terraced_house', 89933.00, 'Description nr 141', 'S', 4),
       (142, 8, 'flat', 157390.00, 'Description nr 142', 'S', 4),
       (143, 8, 'semi_detached_house', 202183.00, 'Description nr 143', 'S', 4),
       (144, 8, 'terraced_house', 227317.00, 'Description nr 144', 'S', 4),
       (145, 8, 'semi_detached_house', 966344.00, 'Description nr 145', 'M', 4),
       (146, 8, 'detached_house', 993909.00, 'Description nr 146', 'S', 4),
       (147, 8, 'detached_house', 294806.00, 'Description nr 147', 'S', 4),
       (148, 8, 'detached_house', 94211.00, 'Description nr 148', 'S', 4),
       (149, 8, 'detached_house', 327376.00, 'Description nr 149', 'S', 4),
       (150, 8, 'flat', 127039.00, 'Description nr 150', 'L', 4),
       (151, 8, 'detached_house', 614673.00, 'Description nr 151', 'S', 4),
       (152, 8, 'detached_house', 129736.00, 'Description nr 152', 'S', 4),
       (153, 8, 'detached_house', 739806.00, 'Description nr 153', 'S', 4),
       (154, 8, 'detached_house', 967569.00, 'Description nr 154', 'S', 4),
       (155, 8, 'semi_detached_house', 217197.00, 'Description nr 155', 'M', 4),
       (156, 8, 'detached_house', 353685.00, 'Description nr 156', 'S', 4),
       (157, 8, 'semi_detached_house', 595884.00, 'Description nr 157', 'S', 4),
       (158, 8, 'terraced_house', 543414.00, 'Description nr 158', 'S', 4),
       (159, 8, 'semi_detached_house', 836104.00, 'Description nr 159', 'S', 4),
       (160, 9, 'detached_house', 341660.00, 'Description nr 160', 'M', 5),
       (161, 9, 'terraced_house', 983399.00, 'Description nr 161', 'S', 5),
       (162, 9, 'semi_detached_house', 396167.00, 'Description nr 162', 'S', 5),
       (163, 9, 'terraced_house', 336073.00, 'Description nr 163', 'S', 5),
       (164, 9, 'flat', 428599.00, 'Description nr 164', 'S', 5),
       (165, 9, 'flat', 527381.00, 'Description nr 165', 'L', 5),
       (166, 9, 'semi_detached_house', 20060.00, 'Description nr 166', 'S', 5),
       (167, 9, 'semi_detached_house', 676491.00, 'Description nr 167', 'S', 5),
       (168, 9, 'semi_detached_house', 100855.00, 'Description nr 168', 'S', 5),
       (169, 9, 'semi_detached_house', 806853.00, 'Description nr 169', 'S', 5),
       (170, 9, 'flat', 49177.00, 'Description nr 170', 'M', 5),
       (171, 9, 'flat', 210445.00, 'Description nr 171', 'S', 5),
       (172, 9, 'semi_detached_house', 154379.00, 'Description nr 172', 'S', 5),
       (173, 9, 'terraced_house', 392279.00, 'Description nr 173', 'S', 5),
       (174, 9, 'semi_detached_house', 983277.00, 'Description nr 174', 'S', 5),
       (175, 9, 'detached_house', 210673.00, 'Description nr 175', 'M', 5),
       (176, 9, 'terraced_house', 279991.00, 'Description nr 176', 'S', 5),
       (177, 9, 'flat', 732249.00, 'Description nr 177', 'S', 5),
       (178, 9, 'semi_detached_house', 639319.00, 'Description nr 178', 'S', 5),
       (179, 9, 'flat', 381344.00, 'Description nr 179', 'S', 5),
       (180, 10, 'flat', 631496.00, 'Description nr 180', 'L', 5),
       (181, 10, 'detached_house', 749915.00, 'Description nr 181', 'S', 5),
       (182, 10, 'detached_house', 678808.00, 'Description nr 182', 'S', 5),
       (183, 10, 'terraced_house', 47583.00, 'Description nr 183', 'S', 5),
       (184, 10, 'detached_house', 762922.00, 'Description nr 184', 'S', 5),
       (185, 10, 'semi_detached_house', 132885.00, 'Description nr 185', 'M', 5),
       (186, 10, 'semi_detached_house', 704989.00, 'Description nr 186', 'S', 5),
       (187, 10, 'detached_house', 375561.00, 'Description nr 187', 'S', 5),
       (188, 10, 'terraced_house', 493059.00, 'Description nr 188', 'S', 5),
       (189, 10, 'flat', 951370.00, 'Description nr 189', 'S', 5),
       (190, 10, 'semi_detached_house', 280857.00, 'Description nr 190', 'M', 5),
       (191, 10, 'semi_detached_house', 805150.00, 'Description nr 191', 'S', 5),
       (192, 10, 'flat', 110297.00, 'Description nr 192', 'S', 5),
       (193, 10, 'terraced_house', 844879.00, 'Description nr 193', 'S', 5),
       (194, 10, 'flat', 60012.00, 'Description nr 194', 'S', 5),
       (195, 10, 'flat', 380580.00, 'Description nr 195', 'L', 5),
       (196, 10, 'terraced_house', 992301.00, 'Description nr 196', 'S', 5),
       (197, 10, 'terraced_house', 884509.00, 'Description nr 197', 'S', 5),
       (198, 10, 'flat', 891926.00, 'Description nr 198', 'S', 5),
       (199, 10, 'terraced_house', 499708.00, 'Description nr 199', 'S', 5);