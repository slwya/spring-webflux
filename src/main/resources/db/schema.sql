drop table if exists PRODUCT;
drop table if exists REVIEW;

CREATE TABLE PRODUCT
(
    productCode  BIGINT NOT NULL AUTO_INCREMENT,
    productName VARCHAR(50) NOT NULL,
    price   BIGINT NOT NULL,
    PRIMARY KEY (productCode)
);

CREATE TABLE REVIEW
(
    reviewCode  BIGINT NOT NULL AUTO_INCREMENT,
    productCode BIGINT NOT NULL,
    content VARCHAR(500) NOT NULL,
    score   TINYINT NOT NULL,
    PRIMARY KEY (reviewCode)
);
