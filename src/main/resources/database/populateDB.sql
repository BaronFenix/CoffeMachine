DO 
'
DECLARE
BEGIN
    IF EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = ''recipes'') THEN
		IF NOT EXISTS (SELECT * FROM recipes) THEN 
	        INSERT INTO recipes (name, coffee, milk, water)
	        VALUES
	            (''Каппучино'', 30, 150, 200),
	            (''Эспрессо'', 30, 0, 200),
	            (''Американо'', 30, 0, 400);
	    END IF;
    END IF;
END; 
' LANGUAGE PLPGSQL;


DO
'
DECLARE 
BEGIN
    IF EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = ''products'') THEN
        IF NOT EXISTS (SELECT * FROM products) THEN
            INSERT INTO products (recipe_id, size, price)
            VALUES 
                (1, 350, 1100),
                (2, 200, 700),
                (3, 400, 900);
        END IF;
    END IF;
END;
' LANGUAGE PLPGSQL;
