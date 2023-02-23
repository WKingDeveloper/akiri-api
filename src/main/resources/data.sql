SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `Product`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `Product` (`id`, `createdAt`, `updatedAt`, `version`, `platform`, `url`, `brand`, `title`, `imageUrl`, `category`, `originCategory`, `currencyCode`, `retailPrice`, `salePrice`, `discountRate`, `status`)
VALUES
    (1, '2023-01-14 14:12:30', '2023-01-14 14:12:30', 0, '29cm', 'https://www.29cm.co.kr/product/804631', '아소부', '[리퍼상품 한정판매] 캐나다 아소부 스테인레스 리유저블 스트로우', 'https://img.29cm.co.kr/next-product/2020/09/03/b95a7220a34446299f1b86bb44ce6c74_20200903162829.jpg?width=700', 'HOME_ELECTRONICS', '가전', 'KRW', 18900.00, 8000.00, 58, 'SALE'),
    (2, '2023-01-14 15:02:23', '2023-01-14 15:02:23', 0, '29cm', 'https://www.29cm.co.kr/product/804476', '아소부', '[리퍼상품 한정판매] 캐나다 아소부 대용량 트라이탄 캠핑앤펫보틀 1.5L 버건디 (실리콘 보울 포함)', 'https://img.29cm.co.kr/next-product/2020/09/03/740ccb4553894f518810d90b1ae42990_20200903154719.jpg?width=700', 'HOME_ELECTRONICS', '가전', 'KRW', 39900.00, 16500.00, 59, 'SALE');
COMMIT;
