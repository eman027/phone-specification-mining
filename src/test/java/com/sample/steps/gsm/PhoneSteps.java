package com.sample.steps.gsm;

import com.sample.model.PhoneSpecs;
import com.sample.steps.gsm.common.PhoneBrandEnum;
import com.sample.ui.WebDriverSession;
import com.sample.ui.WebDriverSteps;
import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.sample.ui.WebDriverSession.getWebDriverSession;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class PhoneSteps {

    public static void clickPhone(WebDriverSteps nav, String phoneModel) {
        int x = 0;
        WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), 20);
        WebDriver webDriverSession = getWebDriverSession();
        writeDetails(null, true, null);
        //Page

        List<WebElement> elements = webDriverSession.findElements(By.xpath("//*[@id='body']/div/div[3]/div[1]/a"));

        //Start 0
        int page = 0;
        int pageSize = elements.size() + 1;
//        int pageSize = page + 1;


//        WebElement list = webDriverSession.findElement(By.xpath("//div[@id='review-body']/div[1]/ul/li"));
        do {
            if (page != 0) {
                WebElement element = webDriverSession.findElement(By.xpath(getPageElement(page)));
                element.click();
                webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
            List<WebElement> webElementList = webDriverSession.findElements(By.xpath("//div[@id='review-body']/div[1]/ul/li"));


            System.out.println(webElementList.size());
            //Start 1
            for (int i = 1; i <= webElementList.size(); i++) {
                WebElement element = webDriverSession.findElement(By.xpath(getPath(i)));
                String href = element.getAttribute("href");
                webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

                WebDriverWait waitMe2 = new WebDriverWait(webDriverSession, 60);
                WebElement elementClick2 = waitMe2.until(ExpectedConditions.elementToBeClickable(element));
                elementClick2.click();

                webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                PhoneSpecs phoneSpecs = getDetails();
                System.out.println("Page: " + page + " | Phone No.: " + i);
                writeDetails(phoneSpecs, false, href);
                webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                WebElement phoneBrand = PhoneBrandEnum.getPhoneLocation(webDriverSession, phoneModel);

                WebDriverWait waitMe = new WebDriverWait(webDriverSession, 60);
                WebElement elementClick = waitMe.until(ExpectedConditions.elementToBeClickable(phoneBrand));
                elementClick.click();


                webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                if (page != 0) {
                    WebElement element1 = webDriverSession.findElement(By.xpath(getPageElement(page)));
                    element1.click();
                    webDriverSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                }
            }
            page++;
        } while (page < pageSize);

    }

    private static String getPageElement(int page) {
        return "//*[@id='body']/div/div[3]/div[1]/a[" + page + "]";
    }

    private static PhoneSpecs getDetails() {
        PhoneSpecs phoneSpecs = new PhoneSpecs();
        WebDriver webDriverSession = getWebDriverSession();
        String brandModel = webDriverSession.findElement(By.xpath("//*[@id='body']/div/div[1]/div/div[1]/h1")).getText();
        String brand = brandModel.substring(0, brandModel.indexOf(' '));
        String model = brandModel.substring(brandModel.indexOf(' ') + 1);
        phoneSpecs.setBrand(brand);
        phoneSpecs.setModel(model);

        String dimension = webDriverSession.findElement(By.xpath("//*[@id='specs-list']/table[3]/tbody/tr[1]/td[2]")).getText();
        String[] dimensionList = dimension.split(" x ");
        if (dimensionList.length == 5) {
            if (dimensionList[0].contains("Unfolded")) {
                phoneSpecs.setLengthMm(dimensionList[0].substring(dimensionList[0].indexOf(" ") + 1));
                phoneSpecs.setWidthMm(dimensionList[1]);
                phoneSpecs.setThicknessMm(dimensionList[2].substring(0, dimensionList[2].indexOf(" mm")));
            } else {
                phoneSpecs.setLengthMm(dimensionList[0]);
                phoneSpecs.setWidthMm(dimensionList[1]);
                phoneSpecs.setThicknessMm(dimensionList[2].substring(0, dimensionList[2].indexOf(" mm")));
                phoneSpecs.setLengthInches(dimensionList[2].substring(dimensionList[2].indexOf("(") + 1));
                if (dimensionList[4].indexOf(" in") > 0) {
                    phoneSpecs.setWidthInches(dimensionList[3]);
                    phoneSpecs.setDimension(phoneSpecs.getLengthInches() + " x " + phoneSpecs.getWidthInches());
                    phoneSpecs.setThicknessInches(dimensionList[4].substring(0, dimensionList[4].indexOf(" in")));
                }
            }
        }
        String size = webDriverSession.findElement(By.xpath("//*[@id='specs-list']/table[4]/tbody/tr[2]/td[2]")).getText();
        if (size.indexOf(" in") > 0) {
            phoneSpecs.setSizeInches(size.substring(0, size.indexOf(" in")));
        }


        String year = webDriverSession.findElement(By.xpath("//*[@id='specs-list']/table[2]/tbody/tr[2]/td[2]")).getText();
        if (Objects.nonNull(year) && (year.toUpperCase().contains("DISCONTINUED") || year.toUpperCase().contains("CANCELLED"))) {
            year = webDriverSession.findElement(By.xpath("//*[@id='specs-list']/table[2]/tbody/tr[1]/td[2]")).getText();
        }

        List<String> years = null;
        if (Objects.nonNull(year)) {
            year = year.replaceAll("[^0-9]", " ");
            year = year.trim();
            year = year.replaceAll(" +", " ");
            years = new ArrayList<>(Arrays.asList(year.split(" ")));
        }
        if (!CollectionUtils.isEmpty(years)) {
            for (int i = years.size(); i > 0; i--) {
                year = years.get(years.size() - i);
                if (!"".equals(year) && Integer.parseInt(year) > 1980 && Integer.parseInt(year) < 2030) {
                    break;
                }
            }

        }
        phoneSpecs.setYear(year);

        System.out.println(phoneSpecs);
        return phoneSpecs;
    }

    private static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static void writeDetails(PhoneSpecs phoneSpecs, boolean isHeader, String href) {
        // Convert the string to a
        // byte array.
        StringBuilder stringBuilder = null;
        if (isHeader) {
            String headerVal = "Brand|Model|Length (in)|Width (in)|Thickness (in)|Dimension|Length (mm)|Width (mm)|Thickness (mm)|Size (in)|Camera Position|Year|Link";
            stringBuilder = new StringBuilder(headerVal);
        } else {
            stringBuilder = new StringBuilder("\n");
            stringBuilder.append(phoneSpecs.getBrand()).append("|")
                    .append(phoneSpecs.getModel()).append("|")
                    .append(phoneSpecs.getLengthInches()).append("|")
                    .append(phoneSpecs.getWidthInches()).append("|")
                    .append(phoneSpecs.getThicknessInches()).append("|")
                    .append(phoneSpecs.getDimension()).append("|")
                    .append(phoneSpecs.getLengthMm()).append("|")
                    .append(phoneSpecs.getWidthMm()).append("|")
                    .append(phoneSpecs.getThicknessMm()).append("|")
                    .append(phoneSpecs.getSizeInches()).append("|")
                    .append("TBD").append("|")
                    .append(phoneSpecs.getYear()).append("|")
                    .append(href);
        }


        String s = stringBuilder.toString();
        byte data[] = s.getBytes();
        Path p = Paths.get("./logfile.txt");

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }

    }


    private static String getPath(int i) {
        return "//div[@id='review-body']/div[1]/ul/li[" + i + "]/a";
    }
}
