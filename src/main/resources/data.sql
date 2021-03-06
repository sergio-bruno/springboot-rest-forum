/* senha 123456 */
INSERT INTO USUARIO(nome, email, senha) VALUES('sergio', 'sergio.bruno.ti@gmail.com', '$2a$10$JSZgukKAFXwgvuZ/QHf2weuOgY3X.D.ErmfBG9wrwadJ4zn/OZhXC');
INSERT INTO USUARIO(nome, email, senha) VALUES('moderador', 'moderador@gmail.com', '$2a$10$JSZgukKAFXwgvuZ/QHf2weuOgY3X.D.ErmfBG9wrwadJ4zn/OZhXC');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_ALUNO');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2,2);

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Microserviços', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('Java JPA', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('ReactJs', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 1', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 4);