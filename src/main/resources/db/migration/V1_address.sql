DROP TABLE IF EXISTS address;

create table address
(
    id        bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    city      varchar(255) null,
    street    varchar(255) null,
    street_no varchar(255) null,
    email     varchar(255) not null,
    phone     varchar(255) not null,
    url       varchar(255) not null,
    hotel_id  bigint null

);

INSERT INTO address(city, street, street_no, email, phone, url, hotel_id)
VALUES ('Kraków', 'aleja 3 Maja ', '2', 'energylandia@contact.pl', '574158258', 'https://www.energylandia.pl', 1),
       ('Warszawa', 'Plac Artura Zawiszy', '1', 'info.sobieski.warsaw@radisinblu.com', '+48 22 579 1000','https://www.radissonhotels.com/pl-pl/hotele/radisson-blu-warsaw-sobieski#', 3),
       ('Budapeszt', 'Kraviec', '10/13', 'reservation@hotelclarkbudapest.hu', '00 36  610 4890','https://hotelclarkbudapest.hu/en/', 4),
       ('Kaiserslautern', 'Bremerhof', '1', 'tobias.maurer@bremerhof-kl.de', '+49 631 316 320', 'https://via.eviivo.com/Google/hotelbremerhof67663?startdate=2021-07-26&enddate=2021-07-27&adults1=2&currency=PLN&bookingSource=cpa&gclid=CjwKCAjww-CGBhALEiwAQzWxOn7-SCxySYhCKnrf043U-OOFdbSjq6IxVzwgbETe8Dd0Pq4p1OEdIhoCMi4QAvD_BwE', 5),
       ('Gdańsk', 'Długa', '84/85', 'kontakt@liberumgdansk.pl', '+ 48 729199099', 'https://www.liberumgdansk.pl', 21);


