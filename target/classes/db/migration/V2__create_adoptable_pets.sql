CREATE TABLE adoptable_pets (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    img_url VARCHAR NOT NULL,
    age INTEGER,
    vaccination_status BOOLEAN,
    adoption_story TEXT NOT NULL,
    adoption_status VARCHAR NOT NULL,
    type_id INTEGER REFERENCES pet_types(id)
);
