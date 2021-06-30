INSERT INTO public.address(
    address_id, address_city, address_country, address_number, address_street)
VALUES (1, 'Le Quesnoy', 'France', 8, 'Rue du Java'),
       (2, 'Paris', 'France', 12, 'Rue du Java');

INSERT INTO public.center(
    center_id, center_comment, center_mail, center_name, center_phone, center_picture, address_id)
VALUES (1, 'Center de renomée inconnue', 'random@random.random', 'Random1', '01.00.01.00.01', 'picture', 1),
       (2, 'Center de renomée européenne', 'europe@europe.europe', 'Europe1', '01.02.01.02.01', 'picture', 2);

INSERT INTO public.client(
    client_id, client_mail, client_phone, client_wording, address_id)
VALUES (1, 'afpa@afpa.afpa', '03.27.03.03.03', 'Best client', 1),
       (2, 'sbc@sbc.sbc', '03.27.11.22.33', 'Second best client', 2);

INSERT INTO public.documenttype(
    documenttype_id, documenttype_name)
VALUES (1, 'Note de frais'),
       (2, 'Fiche de paie');

INSERT INTO public.posttype(
    post_id, post_name)
VALUES (1, 'Animateur trip adulte'),
       (2, 'Animateur trip enfant');

INSERT INTO public.role(
    role_id, role_type)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN'),
       (3, 'ROLE_MODERATOR');

INSERT INTO public.trip(
    trip_id, trip_end_date, trip_start_date, center_id, client_id)
VALUES (1, '2021-06-20', '2021-04-20', 1, 1),
       (2, '2021-09-20', '2021-04-18', 2, 2);

INSERT INTO public.userentity(
    user_id, name_user, user_date_of_birth, user_entry_date, user_lastname, user_mail, user_nss, user_password, user_phone, user_username, address_id, role_id)
VALUES (1, 'Jacques', '1990-05-28', '2021-03-26', 'Emp', 'jacques.emp@emp.emp', 32, 12345678, '00.01.00.01.05', 'Ceasar', 1, 1),
       (2, 'Mike', '1990-05-22', '2021-03-26', 'D', 'jacques.emp@emp.emp', 38, 12345678, '00.01.05.05.05', 'Kars', 2, 2);

INSERT INTO public.document(
    document_id, document_link, document_name, documenttype_id, trip_id, user_id)
VALUES (1, 'document', 'frais de jacques', 1, 1, 1),
       (2, 'document', 'fiche de paie de Mike', 2, 2, 2);

INSERT INTO public.post(
    trip_id, user_id, post_id)
VALUES (1, 1, 1),
       (2, 2, 2);