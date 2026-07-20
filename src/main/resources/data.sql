INSERT INTO app_user (
    user_id,
    user_name,
    password
) VALUES (
    'user1',
    'ユーザー1',
    '$2a$10$AMvVXZJZzvO9FvLaR5tFTOwOxIYl2TGzB.4ZWchpOQscReQeR9JHC'
);

INSERT INTO app_user (
    user_id,
    user_name,
    password
) VALUES (
    'user2',
    'ユーザー2',
    '$2a$10$AMvVXZJZzvO9FvLaR5tFTOwOxIYl2TGzB.4ZWchpOQscReQeR9JHC'
);


INSERT INTO health_check (
    user_id,
    check_date,
    height,
    weight,
    bmi,
    systolic_blood_pressure,
    diastolic_blood_pressure,
    result
) VALUES (
    'user1',
    '2026-07-01',
    170.0,
    65.0,
    22.5,
    120,
    80,
    'A'
);

INSERT INTO health_check (
    user_id,
    check_date,
    height,
    weight,
    bmi,
    systolic_blood_pressure,
    diastolic_blood_pressure,
    result
) VALUES (
    'user1',
    '2026-07-10',
    170.0,
    66.0,
    22.8,
    125,
    82,
    'B'
);

INSERT INTO health_check (
    user_id,
    check_date,
    height,
    weight,
    bmi,
    systolic_blood_pressure,
    diastolic_blood_pressure,
    result
) VALUES (
    'user2',
    '2026-07-05',
    160.0,
    52.0,
    20.3,
    110,
    70,
    'A'
);