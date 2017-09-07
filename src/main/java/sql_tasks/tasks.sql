
-- 1 task
SELECT
  (SELECT count(news.n_id) FROM news )
  +
  ( SELECT count(reviews.r_id) FROM reviews
);

-- 2 task
SELECT nc_name, count(n_category) FROM news_categories
LEFT JOIN news ON news_categories.nc_id = news.n_category
GROUP BY nc_name;

-- 3 task
SELECT rc_name, count(r_category) FROM reviews_categories
LEFT JOIN reviews ON reviews_categories.rc_id = reviews.r_category
GROUP BY rc_name;

-- 4 task
SELECT nc_name, max(n_dt) FROM news_categories
    LEFT JOIN news ON news_categories.nc_id = news.n_category
    WHERE n_dt IS NOT null
    GROUP BY nc_name
UNION ALL
SELECT rc_name, max(r_dt) FROM reviews_categories
    LEFT JOIN reviews ON reviews_categories.rc_id = reviews.r_category
    WHERE r_dt IS NOT NULL
    GROUP BY rc_name;

-- 5 task
SELECT p_name, banners.b_id, b_url FROM pages
    LEFT JOIN m2m_banners_pages ON pages.p_id = m2m_banners_pages.p_id
    LEFT JOIN banners ON m2m_banners_pages.b_id = banners.b_id
    WHERE p_parent IS NULL;

-- 6 task
SELECT p_name FROM pages WHERE exists(
    SELECT * FROM m2m_banners_pages as z
    INNER JOIN banners as b ON b.b_id = z.b_id
    WHERE z.p_id = pages.p_id
);

SELECT DISTINCT p_name FROM pages
    INNER JOIN m2m_banners_pages ON pages.p_id = m2m_banners_pages.p_id
    INNER JOIN banners ON m2m_banners_pages.b_id = banners.b_id
WHERE banners.b_id IS NOT NULL;

-- 7 task
SELECT DISTINCT p_name FROM pages
  LEFT JOIN m2m_banners_pages ON pages.p_id = m2m_banners_pages.p_id
  LEFT JOIN banners ON m2m_banners_pages.b_id = banners.b_id
WHERE banners.b_id IS NULL;

-- 8 task
SELECT b_id, b_url FROM banners as b
    WHERE exists(
      SELECT * FROM m2m_banners_pages AS m
      INNER JOIN pages AS p ON m.p_id = p.p_id
      WHERE m.b_id = b.b_id
    );

-- 9 task
SELECT b_id, b_url FROM banners as b
WHERE NOT exists(
    SELECT * FROM m2m_banners_pages AS m
      INNER JOIN pages AS p ON m.p_id = p.p_id
    WHERE m.b_id = b.b_id
);

-- 10 task
SELECT b_id, b_url, b.b_click / b.b_show * 100 as rate FROM banners as b
  WHERE b.b_click / b.b_show >= 0.8;

-- 11 task
SELECT DISTINCT p_name FROM pages
  LEFT JOIN m2m_banners_pages ON pages.p_id = m2m_banners_pages.p_id
  LEFT JOIN banners ON m2m_banners_pages.b_id = banners.b_id
WHERE banners.b_text IS NOT NULL;

-- 12 task
SELECT DISTINCT p_name FROM pages
  LEFT JOIN m2m_banners_pages ON pages.p_id = m2m_banners_pages.p_id
  LEFT JOIN banners ON m2m_banners_pages.b_id = banners.b_id
WHERE banners.b_pic IS NOT NULL;

-- 13 task
SELECT n_header, n_dt FROM news
    WHERE year(n_dt) = 2011
UNION ALL
SELECT r_header, r_dt FROM reviews
    WHERE year(r_dt) = 2011;


-- 14 task
SELECT nc_name FROM news_categories
    WHERE NOT exists(
        SELECT *
        FROM news
        WHERE n_category = news_categories.nc_id
    )
UNION ALL
SELECT rc_name FROM reviews_categories
  WHERE NOT exists(
    SELECT * FROM reviews WHERE r_category = reviews_categories.rc_id
  );

-- 15 task
SELECT n_header, n_dt FROM news
  INNER JOIN news_categories ON news.n_category = news_categories.nc_id
  WHERE year(n_dt) = 2012 AND nc_id = 3;

-- 16 task
SELECT year(n_dt) AS year, count(*) FROM news
  GROUP BY year(n_dt);

-- 17 task
SELECT b_url, b_id FROM banners AS b
    WHERE b_url IN (
      SELECT  a.b_url FROM banners as a
      GROUP BY b_url HAVING count(*) > 1
    );

 -- 18 task
SELECT p_name, banners.b_id, b_url FROM pages
  INNER JOIN m2m_banners_pages ON pages.p_id = m2m_banners_pages.p_id
  INNER JOIN banners ON m2m_banners_pages.b_id = banners.b_id
  WHERE p_parent = 1;


-- 19 task
SELECT b_id, b_url, b.b_click / b.b_show * 100 as rate FROM banners as b
WHERE b_pic IS NOT NULL
ORDER BY rate DESC;


-- 20 task



