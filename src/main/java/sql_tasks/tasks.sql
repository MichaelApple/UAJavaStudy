
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