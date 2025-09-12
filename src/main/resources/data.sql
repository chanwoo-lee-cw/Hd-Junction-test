INSERT INTO code_group (code_group, code_group_name, description) VALUES ('성별코드', '성별코드', '성별을 표시');
INSERT INTO code_group (code_group, code_group_name, description) VALUES ('방문상태코드', '방문상태코드', '환자의 방문의 상태(방문증, 종료, 취소)');
INSERT INTO code_group (code_group, code_group_name, description) VALUES ('진료과목코드', '진료과목코드', '진료가목(내과, 안과 등)');
INSERT INTO code_group (code_group, code_group_name, description) VALUES ('진료유형코드', '진료유형코드', '진료의 유형(약처방, 검사 등)');

INSERT INTO code (code_group, code, code_name) VALUES ('성별코드', 'M', '남');
INSERT INTO code (code_group, code, code_name) VALUES ('성별코드', 'F', '여');
INSERT INTO code (code_group, code, code_name) VALUES ('방문상태코드', '1', '방문중');
INSERT INTO code (code_group, code, code_name) VALUES ('방문상태코드', '2', '종료');
INSERT INTO code (code_group, code, code_name) VALUES ('방문상태코드', '3', '취소');
INSERT INTO code (code_group, code, code_name) VALUES ('진료과목코드', '01', '내과');
INSERT INTO code (code_group, code, code_name) VALUES ('진료과목코드', '02', '안과');
INSERT INTO code (code_group, code, code_name) VALUES ('진료유형코드', 'D', '약처방');
INSERT INTO code (code_group, code, code_name) VALUES ('진료유형코드', 'T', '검사');

INSERT INTO hospitals (name, institution_code, owner_name, created_at, updated_at) VALUES ('테스트 병원', '1234', '헬로월드', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
