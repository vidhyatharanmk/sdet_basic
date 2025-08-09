import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time

URL = "http://webdriveruniversity.com/index.html"


def test_launch_and_verify_title(driver):
    driver.get(URL)
    assert "Automation & AI Testing Courses by Gianni Bruno | WebDriver University" in driver.title


def test_click_link_and_switch_tab(driver):
    main_window = driver.current_window_handle
    dropdown_link = driver.find_element(
        By.ID, "dropdown-checkboxes-radiobuttons")
    dropdown_link.click()
    time.sleep(5)

    # Switch to new tab
    windows = driver.window_handles
    for window in windows:
        if window != main_window:
            driver.switch_to.window(window)
            break
    
    print("\nDriver Title: " + driver.title + "\n")
    assert "WebDriver | Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)" in driver.title


def test_select_dropdown_and_verify(driver):
    dropdown = Select(driver.find_element(By.ID, "dropdowm-menu-1"))
    dropdown.select_by_visible_text("Python")
    selected_option = dropdown.first_selected_option.text
    print("\nDropdown Selected Option: " + selected_option + "\n")
    assert selected_option == "Python"
    time.sleep(5)


def test_checkboxes_count(driver):
    checkboxes = driver.find_elements(
        By.CSS_SELECTOR, "input[type='checkbox']")
    checked = 0
    unchecked = 0

    for checkbox in checkboxes:
        if not checkbox.is_selected():
            checkbox.click()
            print("\nCheckbox if loop :")
            checked += 1
            print("Checkbox if loop checked : " + str(checked))
        else:
            print("Checkbox else loop :")
            checked += 1
            print("Checkbox else loop checked : " + str(checked))

    unchecked = len(checkboxes) - checked
    print("Checkbox checked : " + str(checked))
    print("Checkbox unchecked : " + str(unchecked))
    assert checked > 0
    assert unchecked == 0


def test_radio_buttons_count(driver):
    radio_buttons = driver.find_elements(By.CSS_SELECTOR, "#radio-buttons input[type='radio']")
    # radio_buttons = driver.find_elements(By.CSS_SELECTOR, "input[type='radio']")
    checked = 0
    unchecked = 0

    # Select one radio button
    if radio_buttons:
        radio_buttons[1].click()

    for radio in radio_buttons:
        if radio.is_selected():
            print("\nRadio button if : ")
            checked += 1
            print("Radio button if checked : " + str(checked))
        else:
            print("\nRadio button else : ")
            unchecked += 1
            print("Radio button else unchecked : " + str(unchecked))
    
    print("Radio button checked : " + str(checked))
    print("Radio button unchecked : " + str(unchecked))
    assert checked == 1
    assert unchecked == len(radio_buttons) - 1