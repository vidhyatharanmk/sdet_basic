import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture
def driver():
    options = webdriver.ChromeOptions()
    driver = webdriver.Chrome(options=options)
    yield driver
    driver.quit()

def test_w3schools_logo_present(driver):
    """
    Test to check if the W3Schools logo is present on the homepage.
    pytest -sv sdet_basic/w3schools.py
    """
    driver.get("https://www.w3schools.com/")
    logoxpath = '//*[@id="w3-logo"]/i'
    logo = driver.find_element(By.XPATH, logoxpath)
    print(logo)
    assert logo.is_displayed(), "W3Schools logo is not present on the page"
    