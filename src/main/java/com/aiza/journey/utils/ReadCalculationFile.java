package com.aiza.journey.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.aiza.journey.payslip.SalaryItemTypeName;

public class ReadCalculationFile {

	private static final int COL_1_LENGTH = 10;
	private static final int COL_2_LENGTH = 50;
	private static final int COL_3_LENGTH = 12;
	private static final int COL_4_LENGTH = 12;
	private static final int COL_5_LENGTH = 12;
	private static final int COL_6_LENGTH = 12;
	
	private static final int PART_1_START_COL_1 = 0;
	private static final int PART_1_END_COL_1 = 13;
	private static final int PART_1_START_COL_2 = 14;
	private static final int PART_1_END_COL_2 = 50;
	private static final int PART_1_START_COL_3 = 84;
	private static final int PART_1_END_COL_3 = 94;
	private static final int PART_1_START_COL_4 = 95;
	private static final int PART_1_END_COL_4 = 108;
	private static final int PART_1_START_COL_5 = 111;
	private static final int PART_1_END_COL_5 = 121;
	private static final int PART_1_START_COL_6 = 122;
	private static final int PART_1_END_COL_6 = 135;
	
	private static final int PART_2_START_COL_1 = 0;
	private static final int PART_2_END_COL_1 = 27;
	private static final int PART_2_START_COL_2 = 83;
	private static final int PART_2_END_COL_2 = 96;
	private static final int PART_2_START_COL_3 = 97;
	private static final int PART_2_END_COL_3 = 109;
	private static final int PART_2_START_COL_4 = 110;
	private static final int PART_2_END_COL_4 = 122;
	private static final int PART_2_START_COL_5 = 123;
	private static final int PART_2_END_COL_5 = 138;
	
	static String employee29PartOne = 
			"1000           Monatslohn\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung                                                                 5000.00                                    5'000.00\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"                                                                                                                                         59/62\r\n" + 
			"2075          Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000          Kinderzulage\r\n" + 
			"\r\n" + 
			"3032          Geburtszulage\r\n" + 
			"\r\n" + 
			"6000          Reisespesen\r\n" + 
			"\r\n" + 
			"6020          Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040          Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050          Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070          Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000          Bruttolohn                                                                         5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"5010          AHV-Beitrag                         5.1500%                                        -113.30                                    -113.30\r\n" + 
			"\r\n" + 
			"5020          ALV-Beitrag                         1.1000%\r\n" + 
			"\r\n" + 
			"5030          ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040          NBUV-Beitrag BT A                   1.4600%\r\n" + 
			"\r\n" + 
			"5040          NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041          UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041          UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042          UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042          UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045          KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045          KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046          KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046          KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050          BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051          BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080          Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100          Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110          Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111          Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112          Ausgleich BVG-Einkauf AG\r\n" + 
			"";
	private static String employee29PartTwo = 
			"AHV-Basis                                                                                        5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                                         2'200.00                                  2'200.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                              2'800.00                                  2'800.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                              5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                                        5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                            5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                                   5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                                   5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12\r\n" + 
			"";
	
	// Employee 28
	static String employee28PartOne = 
			"1000           Monatslohn                                               112'500.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld                                                             4'800.00                                                 4'800.00\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                         5'200.00                                                 5'200.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                  -10'000.00                                               -10'000.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                               112'500.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%               -5'793.75     267.80                                                  267.80\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%               -1'155.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                 -37.50       26.00                                                   26.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%               -1'533.00      36.50                                                   36.50\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                -211.05        5.05                                                    5.05\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                -610.00\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                               -7'600.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";
	
	static String employee28PartTwo = 
			"AHV-Basis                                                              112'500.00    -5'200.00                                               -5'200.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                               112'500.00    -5'200.00                                               -5'200.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                 105'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                   7'500.00    -5'200.00                                               -5'200.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                              112'500.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                 105'000.00    -2'500.00                                               -2'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1        112'500.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11             105'000.00    -2'500.00                                               -2'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1        112'500.00    -5'200.00                                               -5'200.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11             100'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee27PartOne = 
			"1000           Monatslohn                                                20'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                        10'000.00                                                10'000.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                  -10'000.00                                               -10'000.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                               20'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                -164.80      164.80                                                  164.80\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                -292.00      146.00                                                  146.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                 -40.20       20.10                                                   20.10\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                -122.00       61.00                                                   61.00\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG";
	
	static String employee27PartTwo = 
			"AHV-Basis                                                               20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                 3'200.00    -3'200.00                                               -3'200.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                     16'800.00    -6'800.00                                               -6'800.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                     20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                               20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                   20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1         20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11              20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1         20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11              20'000.00   -10'000.00                                              -10'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12\r\n" + 
			"";
	
	static String employee26PartOne = 
			"1000           Monatslohn                                                  133000\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                        15000.00                                                 15'000.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                  -15'000.00                                               -15'000.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                               133'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%               -6'849.50     772.50                                                   772.50\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%               -1'386.00       88.00                                                   88.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                 -35.00        35.00                                                   35.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                -1839.6      116.80                                                   116.80\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                -253.25        16.10                                                   16.10\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                -732.00        12.20                                                   12.20\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                               -9'000.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";
	
	static String employee26PartTwo = 
			"AHV-Basis                                                               133'000.00  -15'000.00                                               -15'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                133'000.00  -15'000.00                                               -15'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                  126'000.00   -8'000.00                                                -8'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                    7'000.00   -7'000.00                                                -7'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                               133'000.00  -15'000.00                                               -15'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                  126'000.00   -8'000.00                                                -8'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1         133'000.00  -15'000.00                                               -15'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11              126'000.00   -8'000.00                                                -8'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1         133'000.00  -15'000.00                                               -15'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11              120'000.00   -2'000.00                                                -2'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";

	static String employee25PartOne = 
			"1000           Monatslohn                                                98'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit                                                             11'500.00                                                11'500.00\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                                       9'500.00                                   9'500.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                                 -9'500.00                                   -9'500.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                98'000.00   11'500.00                                                11'500.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%               -5'047.00     -592.25       489.25                                    -103.00\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%               -1'078.00      -77.00        55.00                                     -22.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                              -22.50        22.50\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%               -1'430.80     -102.20        73.00                                     -29.20\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                -197.00       -14.05        10.05                                      -4.00\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                -597.80       -12.20                                                  -12.20\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                               -6'700.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";
	
	static String employee25PartTwo = 
			"AHV-Basis                                                               14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                                          3'200.00                                   3'200.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                     14'000.00                 2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                     14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                               14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                   14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1          14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11               14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1          14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11               14'000.00                 6'000.00                                   6'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12\r\n" + 
			"";
	
	static String employee24PartOne = 
			"1000           Monatslohn                                               330'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke                                                 40000.00                                                40'000.00\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                               330'000.00   40'000.00                                               40'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%              -16'995.00   -2'060.00                                               -2'060.00\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%               -1'386.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                -945.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                -1839.6\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%               -1103.15\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%                -1423.8     -271.20                                                 -271.20\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                              -16'000.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee24PartTwo = 
			"AHV-Basis                                                              330'000.00   40'000.00                                               40'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                               330'000.00   40'000.00                                               40'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                  126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00                                  189'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                     15'000.00   40'000.00                                               40'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                              330'000.00   40'000.00                                               40'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                  126'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1         330'000.00   40'000.00                                               40'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12             174'000.00\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1         330'000.00   40'000.00                                               40'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12             210'000.00   40'000.00                                               40'000.00\r\n" + 
			"";
	
	static String employee23PartOne = 
			"1000           Monatslohn                                                95'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage                                                        22'000.00                                                22'000.00\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                95'000.00   22'000.00                                               22'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%               -4'892.50   -1'133.00                                                -1'133.00\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%               -1'045.00     -110.00                                                 -110.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                              -60.00                                                  -60.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%               -1'387.00     -146.00                                                 -146.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                -190.95       -20.10                                                  -20.10\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                -579.50       -30.50                                                  -30.50\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                               -6'400.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";
	
	static String employee23PartTwo = 
			"AHV-Basis                                                                95'000.00   22'000.00                                               22'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                 95'000.00   22'000.00                                               22'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                   95'000.00   10'000.00                                               10'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                               12'000.00                                               12'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                95'000.00   22'000.00                                               22'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                   95'000.00   10'000.00                                               10'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1          95'000.00   22'000.00                                               22'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11               95'000.00   10'000.00                                               10'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1          95'000.00   22'000.00                                               22'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11               95'000.00    5'000.00                                                5'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee22PartOne =
			"1000           Monatslohn\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn                                               70'560.00   28'000.00                                                28'000.00\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung                                            5'205.90    2'315.75                                                 2'315.75\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung                                     1'999.85      793.60                                                  793.60\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                               77'765.75    31'109.35                                               31'109.35\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%               -4'004.95   -1'602.15                                                -1'602.15\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                -855.40      -245.70                                                 -245.70\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                              -43.90                                                  -43.90\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%               -1'259.80     -361.80                                                 -361.80\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%                -156.30       -44.90                                                  -44.90\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%                -422.25       -95.40                                                  -95.40\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                               -5'600.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee22PartTwo =
			"AHV-Basis                                                               77'765.75    31'109.35                                               31'109.35\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                 77'765.75   31'109.35                                               31'109.35\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                   77'765.75   22'334.25                                               22'334.25\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                                8'775.10                                                8'775.10\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                               77'765.75    31'109.35                                               31'109.35\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                   77'765.75   22'334.25                                               22'334.25\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1         77'765.75    31'109.35                                               31'109.35\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11               77'765.75   22'334.25                                               22'334.25\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1         77'765.75    31'109.35                                               31'109.35\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11               77'765.75   17'567.60                                               17'567.60\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee21PartOne = 
			"1000           Monatslohn                                                            25000.00                                                25'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld                                                                                       3'300.00                      3'300.00\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld                                                                                   4000.00                      4'000.00\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                                              -7'300.00                     -7'300.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                           25'000.00                                               25'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                        5.1500%                           -1'287.50                    206.00                     -1'081.50\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                        1.1000%                             -219.45                                                -219.45\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                       0.5000%                              -25.25                     20.00                        -5.25\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                  1.4600%                             -291.25                     32.85                      -258.40\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                  1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11        0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11        0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12        0.6340%                              -32.00                     32.00\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11         0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11         0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12         0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12         0.7200%                              -79.45                     28.80                       -50.65\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                          -1'700.00                                               -1'700.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";
	
	static String employee21PartTwo = 
			"AHV-Basis                                                                           25'000.00                 -4'000.00                     21'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                            25'000.00                 -4'000.00                     21'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                               19'950.00                                               19'950.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00                                                5'050.00                 -4'000.00                      1'050.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                           25'000.00                 -7'300.00                     17'700.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                               19'950.00                 -2'250.00                     17'700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                      25'000.00                 -7'300.00                     17'700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12                            5'050.00                 -5'050.00\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                      25'000.00                 -4'000.00                     21'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12                           11'035.00                 -4'000.00                      7'035.00\r\n" + 
			"";
	
	static String employee20PartOne = 
			"1000           Monatslohn\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn                                                            5'100.00     2'100.00      2'100.00     5'100.00       14'400.00\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)                                                              3'000.00      3'000.00                     6'000.00\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung                                                                   2'200.00      2'200.00                     4'400.00\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW                                                                       200.00        200.00                       400.00\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                             5'100.00     4'500.00     4'500.00     5'100.00        19'200.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                             -262.65      -262.65      -190.55      -118.45          -834.30\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                              -56.10       -56.10                                    -112.20\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                              -74.45       -74.45       -74.45       -74.45          -297.80\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                              -10.25       -10.25       -10.25       -10.25           -41.00\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                              -31.10       -31.10       -31.10       -31.10          -124.40\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                             -400.00      -400.00                                    -800.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";
	
	static String employee20PartTwo = 
			"AHV-Basis                                                                             5'100.00     5'100.00     5'100.00     5'100.00        20'400.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                              5'100.00     5'100.00     3'700.00     2'300.00        16'200.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                                             1'400.00     2'800.00         4'200.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                                5'100.00     5'100.00                                  10'200.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                                             5'100.00     5'100.00        10'200.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                             5'100.00     5'100.00     5'100.00     5'100.00        20'400.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                                5'100.00     5'100.00     5'100.00     5'100.00        20'400.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                       5'100.00     5'100.00     5'100.00     5'100.00        20'400.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11                            5'100.00     5'100.00     5'100.00     5'100.00        20'400.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                       5'100.00     5'100.00     5'100.00     5'100.00        20'400.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11                            5'100.00     5'100.00     5'100.00     5'100.00        20'400.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee19PartOne = 
			"1000           Monatslohn                                                             6'400.00     6'400.00     6'400.00      6'400.00       25'600.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)                                                               -3'000.00                                   -3'000.00\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung                                                                   2'200.00                                   2'200.00\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW                                                                       200.00                                     200.00\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                             6'400.00     5'800.00     6'400.00     6'400.00        25'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                             -329.60      -329.60      -329.60      -329.60         -1'318.40\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                              -70.40       -70.40       -70.40       -70.40          -281.60\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                              -93.45       -93.45       -93.45       -93.45          -373.80\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%                              -12.85       -12.85       -12.85       -12.85           -51.40\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%                              -34.75       -34.75       -34.75       -34.75          -139.00\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                             -500.00      -500.00      -500.00      -500.00         -2'000.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee19PartTwo = 
			"AHV-Basis                                                                             6'400.00     6'400.00     6'400.00     6'400.00        25'600.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                              6'400.00     6'400.00     6'400.00      6'400.00       25'600.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                                6'400.00     6'400.00     6'400.00      6'400.00       25'600.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                             6'400.00     6'400.00     6'400.00     6'400.00        25'600.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                                6'400.00     6'400.00     6'400.00      6'400.00       25'600.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                       6'400.00     6'400.00     6'400.00     6'400.00        25'600.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11                            6'400.00     6'400.00     6'400.00      6'400.00       25'600.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                       6'400.00     6'400.00     6'400.00     6'400.00        25'600.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11                            6'400.00     6'400.00     6'400.00      6'400.00       25'600.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee18PartOne = 
			"1000           Monatslohn                                                             1500.00      1500.00      1500.00      1500.00         6'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke                                                 22000.00                               10000.00         32'000.00\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter                                 6'000.00                                                6'000.00\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                           29'500.00      1'500.00     1'500.00    11'500.00        44'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                           -1'210.25        -5.15         5.15       -25.75        -1'236.00\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                            -231.00                                                 -231.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                             -12.50                                                  -12.50\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                            -306.60        -58.40       -21.90      -167.90         -554.80\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%                             -15.85        15.85\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                                            -9.15        -9.15       -70.15          -88.45\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%                             -63.35                                                  -63.35\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                            -120.00                                                 -120.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee18PartTwo = 
			"AHV-Basis                                                                           23'500.00      1'500.00     1'500.00    11'500.00        38'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                            23'500.00       100.00       -100.00       500.00        24'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                                1'400.00     1'600.00    11'000.00        14'000.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                               21'000.00                                                21'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00                                                 2'500.00                                                2'500.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                                1'500.00     1'500.00    11'500.00        14'500.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                           23'500.00      1'500.00     1'500.00    11'500.00        38'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                               21'000.00      4'000.00     1'500.00    11'500.00        38'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                     23'500.00      1'500.00     1'500.00    11'500.00        38'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12                            2'500.00    -2'500.00\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                     23'500.00      1'500.00     1'500.00    11'500.00        38'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11                                         1'500.00     1'500.00    11'500.00        14'500.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12                            8'800.00                                                8'800.00\r\n" + 
			"";
	
	static String employee17PartOne = 
			"1000           Monatslohn                                                             8'000.00     8'000.00      8'000.00     8'000.00        32'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage                                                             3'000.00     3'000.00      3'000.00     3'000.00        12'000.00\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation                                                                      50'000.00                 235'000.00       285'000.00\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen                                              400.00       400.00       400.00        400.00         1'600.00\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung                                               1'150.00     1'150.00      1'150.00     1'150.00         4'600.00\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG                                    5'000.00                                                 5'000.00\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            17'550.00     62'550.00    12'550.00   247'550.00        340'200.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                             -903.85     -3'221.35      -646.35    -12'748.85       -17'520.40\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                             -193.05       -153.45      -672.65       -366.85        -1'386.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                                           -236.25       236.25       -945.00         -945.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                             -256.25       -203.65      -892.80       -486.90        -1'839.60\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                               -35.30       -28.05      -122.90        -67.05         -253.30\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%                                           -275.80       275.80     -1'103.15        -1'103.15\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                             -107.05        -75.95      -382.15       -166.85         -732.00\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%                               -20.50      -397.45       280.10     -1'676.50        -1'814.35\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                            -5'200.00    -5'200.00     -5'200.00    -5'200.00       -20'800.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen                                            -1'150.00    -1'150.00     -1'150.00    -1'150.00        -4'600.00\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile                                            -400.00       -400.00      -400.00       -400.00        -1'600.00\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG                                               -5'000.00                                                -5'000.00\r\n" + 
			"";

	static String employee17PartTwo = 
			"AHV-Basis                                                                            17'550.00     62'550.00    12'550.00   247'550.00        340'200.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                              17'550.00    62'550.00    12'550.00    247'550.00       340'200.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                                17'550.00    13'950.00    61'150.00     33'350.00       126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                                             47'250.00    -47'250.00   189'000.00       189'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                                 1'350.00     -1'350.00    25'200.00       25'200.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            17'550.00     62'550.00    12'550.00   247'550.00        340'200.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                                17'550.00    13'950.00    61'150.00     33'350.00       126'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                      17'550.00     62'550.00    12'550.00   247'550.00        340'200.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11                            17'550.00    13'950.00    61'150.00     33'350.00       126'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12                                         43'500.00    -43'500.00   174'000.00       174'000.00\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                      17'550.00     62'550.00    12'550.00   247'550.00        340'200.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11                            17'550.00    12'450.00    62'650.00     27'350.00       120'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12                             2'850.00    55'200.00    -38'900.00   232'850.00       252'000.00\r\n" + 
			"";
	
	static String employee16PartOne = 
			"1000           Monatslohn                                                                          5'000.00      5'000.00     5'000.00       15'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation                                                                                     2'000.00     1'000.00        3'000.00\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                                                                22'000.00       22'000.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                                                          -22'000.00       -22'000.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                                          5'000.00     7'000.00     6'000.00        18'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                                         -257.50       -288.40      751.90           206.00\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                                           -55.00                                    -55.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                                           -73.00      -102.20      233.60            58.40\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%                                           -10.05       -14.05        32.15            8.05\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%                                           -27.15       -38.00        86.90           21.75\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                                         -300.00                                    -300.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee16PartTwo = 
			"AHV-Basis                                                                                          5'000.00     7'000.00   -16'000.00        -4'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                                           5'000.00     5'600.00   -14'600.00        -4'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                                             1'400.00    -1'400.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                                              5'000.00                                  5'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                                             7'000.00   -16'000.00        -9'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                                          5'000.00     7'000.00   -16'000.00        -4'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                              5'000.00     7'000.00   -16'000.00        -4'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                                     5'000.00     7'000.00   -16'000.00        -4'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11                                         5'000.00     7'000.00   -16'000.00        -4'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                                     5'000.00     7'000.00   -16'000.00        -4'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11                                         5'000.00     7'000.00   -16'000.00        -4'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12\r\n" + 
			"";
	
	static String employee15PartOne = 
			"1000           Monatslohn                                                              800.00       800.00        800.00       800.00         3'200.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage                                                           3200.00      3200.00                                    6'400.00\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075          Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000          Kinderzulage\r\n" + 
			"\r\n" + 
			"3032          Geburtszulage\r\n" + 
			"\r\n" + 
			"6000          Reisespesen\r\n" + 
			"\r\n" + 
			"6020          Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040          Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050          Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070          Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000          Bruttolohn                                                            4'000.00     4'000.00       800.00       800.00         9'600.00\r\n" + 
			"\r\n" + 
			"5010          AHV-Beitrag                         5.1500%                            -206.00      -133.90       133.90                       -206.00\r\n" + 
			"\r\n" + 
			"5020          ALV-Beitrag                         1.1000%                             -44.00                                                  -44.00\r\n" + 
			"\r\n" + 
			"5030          ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040          NBUV-Beitrag BT A                   1.4600%\r\n" + 
			"\r\n" + 
			"5040          NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041          UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041          UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042          UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042          UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045          KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045          KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046          KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046          KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050          BVG-Beitrag                                                            -240.00                                                 -240.00\r\n" + 
			"\r\n" + 
			"5051          BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080          Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100          Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110          Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111          Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112          Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee15PartTwo = 
			"AHV-Basis                                                                           4'000.00     4'000.00       800.00       800.00         9'600.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                            4'000.00     2'600.00     -2'600.00                     4'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                              1'400.00      3'400.00      800.00         5'600.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                               4'000.00                                                4'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                              4'000.00       800.00       800.00         5'600.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                           4'000.00     4'000.00       800.00       800.00         9'600.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                               4'000.00     4'000.00       800.00       800.00         9'600.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                      4'000.00     4'000.00       800.00       800.00         9'600.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                      4'000.00     4'000.00       800.00       800.00         9'600.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12\r\n" + 
			"";
	
	static String employee14PartOne = 
			"1000           Monatslohn\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn                                                            4'200.00     2'800.00     9'975.00      4'025.00       21'000.00\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                             4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                             -216.30      -144.20      -513.70      -207.30        -1'081.50\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                              -46.20       -30.80      -109.75       -44.30          -231.05\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                              -61.30       -40.90      -145.65       -58.75          -306.60\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%                               -8.45        -5.65       -20.05        -8.10           -42.25\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%                              -22.80       -15.20       -54.15       -21.85          -114.00\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                             -300.00      -300.00      -300.00      -300.00        -1'200.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee14PartTwo = 
			"AHV-Basis                                                                             4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                              4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                                4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                             4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                                4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                       4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11                            4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                       4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11                            4'200.00     2'800.00     9'975.00     4'025.00        21'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee13PartOne = 
			"1000           Monatslohn                                                            17'500.00    17'500.00    17'500.00                     52'500.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke                                                                           60'000.00                     60'000.00\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                                                               15'000.00        15'000.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                                                          -15'000.00      -15'000.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates                                           1'500.00     1'500.00      1'500.00                      4'500.00\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            17'500.00    17'500.00    77'500.00                     112'500.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                             -901.25      -901.25     -3'991.25      772.50         -5'021.25\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                             -192.50      -154.00      -808.50         82.50        -1'072.50\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                                           -17.50        -20.00        37.50\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                                          -204.40     -1'073.10      109.50         -1'168.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%                              -35.20       -28.15      -147.75         15.10         -196.00\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%                              -95.05       -67.90      -380.10         13.60         -529.45\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                           -2'000.00     -2'000.00    -2'000.00                     -6'000.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee13PartTwo = 
			"AHV-Basis                                                                            17'500.00    17'500.00    77'500.00    -15'000.00        97'500.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                             17'500.00    17'500.00     77'500.00   -15'000.00        97'500.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                               17'500.00    14'000.00     73'500.00    -7'500.00        97'500.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                                             3'500.00      4'000.00    -7'500.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            17'500.00    17'500.00    77'500.00    -15'000.00        97'500.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                               17'500.00    14'000.00     73'500.00    -7'500.00        97'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                      17'500.00    17'500.00    77'500.00    -15'000.00        97'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11                           17'500.00    14'000.00     73'500.00    -7'500.00        97'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                      17'500.00    17'500.00    77'500.00    -15'000.00        97'500.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11                           17'500.00    12'500.00     70'000.00    -2'500.00        97'500.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee12PartOne = 
			"1000           Monatslohn                                                             5450.00                    5450.00      5450.00        16'350.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar                                                  300.00      4'000.00                  6'150.00        10'450.00\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            5'750.00      4'000.00     5'450.00    11'600.00        26'800.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                            -296.15      -206.00       -280.70      -597.40        -1'380.25\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                             -63.25        -44.00       -59.95      -115.50         -282.70\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                                                                      -5.50           -5.50\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                             -83.95                     -79.55      -153.30         -316.80\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                             -11.55                     -10.95       -21.10          -43.60\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                             -35.10                     -33.25       -61.00         -129.35\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                            -300.00                    -300.00      -300.00         -900.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee12PartTwo = 
			"AHV-Basis                                                                            5'750.00      4'000.00     5'450.00    11'600.00        26'800.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                             5'750.00      4'000.00     5'450.00    11'600.00        26'800.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                                5'750.00      4'000.00     5'450.00    10'500.00        25'700.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00                                                                                        1'100.00         1'100.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            5'750.00      4'000.00     5'450.00    11'600.00        26'800.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                5'750.00                   5'450.00    10'500.00        21'700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                      5'750.00      4'000.00     5'450.00    11'600.00        26'800.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11                           5'750.00                   5'450.00    10'500.00        21'700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                      5'750.00      4'000.00     5'450.00    11'600.00        26'800.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11                           5'750.00                   5'450.00    10'000.00        21'200.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12\r\n" + 
			"";
	
	static String employee11PartOne = 
			"1000           Monatslohn\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn                                                            6'800.00      7'200.00                                  14'000.00\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation                                                                                    20'000.00                     20'000.00\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG                                              300.00       300.00                                     600.00\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld                                                                           1'200.00                                   1'200.00\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)                                                             1'000.00                                   1'000.00\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                         2'500.00                                                 2'500.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld                                                          500.00                                                  500.00\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                           10'100.00      9'700.00    20'000.00                     39'800.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                            -365.65      -499.55     -1'030.00                     -1'895.20\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                             -78.10      -106.70       -161.70                      -346.50\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                                                        -26.50                       -26.50\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%                            -115.00      -137.70       -257.60                      -510.30\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                             -14.25        -17.10       -31.95                       -63.30\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                             -43.30        -59.15       -80.50                      -182.95\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG                                              -300.00      -300.00                                    -600.00\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee11PartTwo = 
			"AHV-Basis                                                                            7'100.00      9'700.00    20'000.00                     36'800.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                             7'100.00      9'700.00    20'000.00                     36'800.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                                7'100.00      9'700.00    14'700.00                     31'500.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00                                                                           5'300.00                     5'300.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            7'100.00      8'500.00    20'000.00                     35'600.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                7'100.00      8'500.00    15'900.00                     31'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                       7'100.00      8'500.00    20'000.00                     35'600.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11                           7'100.00      8'500.00    15'900.00                     31'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                       7'100.00      9'700.00    20'000.00                     36'800.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11                           7'100.00      9'700.00    13'200.00                     30'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12\r\n" + 
			"";
	
	static String employee10PartOne = 
			"1000           Monatslohn                                                             5'000.00      5'000.00     5'000.00                     15'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%                                                                                              1'200.00         1'200.00\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage                                                             500.00       500.00     31'000.00     7'000.00        39'000.00\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld                                                             1'000.00                                                 1'000.00\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)                                                 800.00                                                  800.00\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                                                    2'000.00                      2'000.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld                                                                                   2'500.00                      2'500.00\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                    -1'800.00                 -4'500.00                     -6'300.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            5'500.00      5'500.00    36'000.00     8'200.00        55'200.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                            -283.25       -283.25    -1'622.25      -422.30        -2'611.05\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                             -60.50        -60.50      -346.50       -90.20          -557.70\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                             -65.70        -80.30      -459.90      -119.70          -725.60\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%                               -9.05       -11.05       -63.30       -16.50           -99.90\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%                             -29.85        -29.85      -171.05       -44.55          -275.30\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                            -300.00       -300.00      -300.00                       -900.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee10PartTwo = 
			"AHV-Basis                                                                            5'500.00      5'500.00    31'500.00     8'200.00        50'700.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                              5'500.00     5'500.00    31'500.00     8'200.00        50'700.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                                 5'500.00     5'500.00    31'500.00     8'200.00        50'700.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            4'500.00      5'500.00    31'500.00     8'200.00        49'700.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                 4'500.00     5'500.00    31'500.00     8'200.00        49'700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                      4'500.00      5'500.00    31'500.00     8'200.00        49'700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11                            4'500.00     5'500.00    31'500.00     8'200.00        49'700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                      5'500.00      5'500.00    31'500.00     8'200.00        50'700.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11                            5'500.00     5'500.00    31'500.00     8'200.00        50'700.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12\r\n" + 
			"";
	
	static String employee9PartOne = 
			"1000           Monatslohn                                                            25000.00                                                25'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung                                                                               4900.00     30500.00        35'400.00\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage                                                            300.00                     100.00       500.00          900.00\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage                                                            200.00                    200.00       400.00           800.00\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage                                                                                                 1000.00         1'000.00\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                           25'500.00                   5'200.00    32'400.00        63'100.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                           -1'302.95                   -257.50    -1'596.50        -3'156.95\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                            -231.00                      -3.85      -231.00         -465.85\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                             -21.50                      -2.65       -70.65          -94.80\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                            -306.60                      -5.10      -306.60         -618.30\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%                             -27.25                      -3.05       -89.80         -120.10\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                            -122.00                      -2.05      -122.00         -246.05\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                           -1'200.00                              -1'200.00        -2'400.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee9PartTwo = 
			"AHV-Basis                                                                           25'300.00                   5'000.00    31'000.00        61'300.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                            25'300.00                   5'000.00    31'000.00        61'300.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                               21'000.00                    350.00     21'000.00        42'350.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00                                                4'300.00                    525.00     14'125.00        18'950.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                                             4'125.00    -4'125.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                           25'300.00                   5'000.00    31'000.00        61'300.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                               21'000.00                    350.00     21'000.00        42'350.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                      25'300.00                   5'000.00    31'000.00        61'300.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00              Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00              Code 12                           4'300.00                    483.35     14'166.65        18'950.00\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                      25'300.00                   5'000.00    31'000.00        61'300.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00              Code 11                          20'000.00                    333.35     20'000.00        40'333.35\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00              Code 12\r\n" + 
			"";
	
	static String employee8PartOne = 
			"1000           Monatslohn                                                             3'500.00     3'500.00     3'500.00     3'500.00        14'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage                                                          12'000.00    16'000.00    60'000.00    53'000.00       141'000.00\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                           15'500.00    19'500.00    63'500.00    56'500.00       155'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                        5.1500%                             -654.05      -932.15     -2'765.55    -2'765.55       -7'117.30\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                        1.1000%\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                       0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                  1.4600%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                  1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11        0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11        0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11         0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11         0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12         0.6780%                               -5.40       -82.40       -81.70      -283.40          -452.90\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12         0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee8PartTwo = 
			"AHV-Basis                                                                           15'500.00    19'500.00    63'500.00    56'500.00       155'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                            12'700.00    18'100.00    53'700.00    53'700.00       138'200.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                  2'800.00     1'400.00     9'800.00     2'800.00        16'800.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                 15'500.00    19'500.00    63'500.00    56'500.00       155'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                           15'500.00    19'500.00    63'500.00    56'500.00       155'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                               15'500.00    16'000.00    67'000.00    27'500.00       126'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                      15'500.00    19'500.00    63'500.00    56'500.00       155'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                      15'500.00    19'500.00    63'500.00    56'500.00       155'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12                              800.00    12'150.00    12'050.00    41'800.00        66'800.00\r\n" + 
			"";
	
	static String employee7PartOne = 
			"1000           Monatslohn                                                             5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen                                                                             10'000.00                     10'000.00\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                        5.1500%\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                        1.1000%\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                       0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                  1.4600%                              -73.00       -73.00      -219.00                       -365.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                  1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11        0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11        0.2010%                              -10.05       -10.05       -30.15        -10.05          -60.30\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11         0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11         0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12         0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12         0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile                                                                   -10'000.00                   -10'000.00\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee7PartTwo = 
			"AHV-Basis                                                                            5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                  5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                  5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                       5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11                            5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                       5'000.00     5'000.00    15'000.00      5'000.00       30'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12\r\n" + 
			"";
	
	static String employee6PartOne = 
			"1000           Monatslohn                                                             5000.00      5000.00      5000.00      5000.00        20'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen                                                            500.00       500.00        500.00       500.00         2'000.00\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                        5.1500%\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                        1.1000%\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                       0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                  1.4600%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                  1.6200%                                           -81.00       -81.00       -81.00         -243.00\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11        0.2010%                                           -10.05       -10.05       -10.05          -30.15\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11        0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11         0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11         0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12         0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12         0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee6PartTwo = 
			"AHV-Basis                                                                            5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                  5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                  5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                             5'000.00     5'000.00     5'000.00        15'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                       5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11                                         5'000.00     5'000.00     5'000.00        15'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                       5'000.00     5'000.00     5'000.00     5'000.00        20'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12\r\n" + 
			"";
	
	static String employee5PartOne = 
			"1000           Monatslohn                                                            45'000.00    45'000.00     45'000.00                    135'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit                                                                                                     10'000.00        10'000.00\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld                                                                          2'000.00                                    2'000.00\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)                                                            1'500.00                                    1'500.00\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld                                                        3'000.00                                                 3'000.00\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                   -3'000.00     -3'500.00                                  -6'500.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen                                                              450.00       450.00       450.00                       1'350.00\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            45'000.00    45'000.00    45'000.00     10'000.00       145'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                           -2'163.00     -2'317.50    -2'317.50      -515.00        -7'313.00\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                             -231.00      -115.50      -808.50                      -1'155.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                             -105.00      -131.25       101.25        -50.00         -185.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%                             -306.60      -153.30     -1'073.10                     -1'533.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%                              -42.20                                                  -42.20\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%                                           -91.95        66.55        -63.40          -88.80\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%                                           -61.00      -427.00                       -488.00\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                           -3'000.00     -3'000.00    -3'000.00                     -9'000.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee5PartTwo = 
			"AHV-Basis                                                                            42'000.00    45'000.00    45'000.00     10'000.00       142'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                             42'000.00    45'000.00     45'000.00    10'000.00       142'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                               21'000.00    10'500.00     73'500.00                    105'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                               21'000.00    26'250.00    -20'250.00    10'000.00        37'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                                8'250.00     -8'250.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            42'000.00    43'000.00    45'000.00     10'000.00       140'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                               21'000.00    10'500.00     73'500.00                    105'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                      42'000.00    43'000.00    45'000.00     10'000.00       140'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11                           21'000.00                                                21'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12                                        14'500.00    -10'500.00    10'000.00        14'000.00\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                      42'000.00    45'000.00    45'000.00     10'000.00       142'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11                                        10'000.00     70'000.00                     80'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12\r\n" + 
			"";
	
	static String employee4PartOne = 
			"1000           Monatslohn\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn                                                                       2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075          Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000          Kinderzulage\r\n" + 
			"\r\n" + 
			"3032          Geburtszulage\r\n" + 
			"\r\n" + 
			"6000          Reisespesen                                                                          257.50                                    257.50\r\n" + 
			"\r\n" + 
			"6020          Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040          Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050          Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070          Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000          Bruttolohn                                                                         2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"5010          AHV-Beitrag                         5.1500%                                         -144.20                                   -144.20\r\n" + 
			"\r\n" + 
			"5020          ALV-Beitrag                         1.1000%                                           -7.70                                     -7.70\r\n" + 
			"\r\n" + 
			"5030          ALVZ-Beitrag                        0.5000%                                           -5.25                                     -5.25\r\n" + 
			"\r\n" + 
			"5040          NBUV-Beitrag BT A                   1.4600%\r\n" + 
			"\r\n" + 
			"5040          NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041          UVGZ-Beitrag Männer Code 11         0.2010%                                           -1.40                                     -1.40\r\n" + 
			"\r\n" + 
			"5041          UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042          UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042          UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045          KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045          KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046          KTG-Beitrag Männer Code 12          0.6780%\r\n" + 
			"\r\n" + 
			"5046          KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050          BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051          BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080          Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100          Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110          Ausgleich geldwerte Vorteile\r\n" + 
			"\r\n" + 
			"5111          Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112          Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee4PartTwo = 
			"AHV-Basis                                                                                        2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                                         2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00                                                              700.00                                    700.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00                                                            1'050.00                                   1'050.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                              1'050.00                                   1'050.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                                        2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                                              700.00                                    700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                                   2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11                                          700.00                                    700.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                                   2'800.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12\r\n" + 
			"";
	
	static String employee3PartOne = 
			"1000           Monatslohn                                                             8000.00     35000.00      35000.00     35000.00       113'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn                                                                                                15'000.00       15'000.00\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung                                                       500.00        500.00       500.00       500.00         2'000.00\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung                                                          2000.00      2000.00       2000.00      2000.00         8'000.00\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen                                                                                            5'000.00        5'000.00\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)                                            2'000.00                                                2'000.00\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld                                                                                    3500.00                      3'500.00\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder                                                                              -3'500.00                     -3'500.00\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen                                                    800.00        800.00       800.00       800.00         3'200.00\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen                                                  300.00        300.00       300.00       300.00         1'200.00\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                            12'500.00    37'500.00    37'500.00    57'500.00       145'000.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                             -540.75    -1'931.25     -1'751.00    -2'961.25        -7'184.25\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                              -15.40      -115.50      -771.10      -268.40         -1'170.40\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                              -10.50       -78.75        89.25      -165.50          -165.50\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%                              -12.25       -91.95       104.20      -209.85          -209.85\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%                              -31.00      -232.65       113.05      -290.20          -440.80\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                           -1'800.00    -1'800.00     -1'800.00    -1'800.00        -7'200.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen                                            -2500.00     -2500.00     -2500.00     -2500.00        -10'000.00\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile                                                                                  -5000.00         -5'000.00\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee3PartTwo = 
			"AHV-Basis                                                                            10'500.00    37'500.00    34'000.00    57'500.00       139'500.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                             10'500.00    37'500.00    34'000.00    57'500.00       139'500.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                                1'400.00    10'500.00    70'100.00    24'400.00       106'400.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                                2'100.00    15'750.00    -17'850.00   33'100.00        33'100.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                   7'000.00    11'250.00    -18'250.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                            10'500.00    37'500.00    34'000.00    57'500.00       139'500.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00                                                1'400.00    10'500.00    70'100.00    24'400.00       106'400.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                      10'500.00    37'500.00    34'000.00    57'500.00       139'500.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12                            1'933.35    14'500.00    -16'433.35   33'100.00        33'100.00\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                      10'500.00    37'500.00    34'000.00    57'500.00       139'500.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12                            4'575.55    34'316.65    -16'672.20   42'800.00        65'020.00\r\n" + 
			"";
	
	static String employee2PartOne = 
			"1000           Monatslohn\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn                                                            7'827.60    10'214.45                                   18'042.05\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage                                                           4'000.00                                                 4'000.00\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar                                                              5'000.00                                    5'000.00\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG                                                           250.00                                     250.00\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b                                         150.00       150.00                                     300.00\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a                                         350.00       350.00                                     700.00\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen                                        300.00        300.00                                    600.00\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                           12'327.60    15'964.45                                  28'292.05\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                        5.1500%                             -562.75      -737.20                                  -1'299.95\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                        1.1000%\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                       0.5000%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                  1.4600%                             -153.30      -137.95                                   -291.25\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                  1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11        0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11        0.2010%                                           -19.00                                    -19.00\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12        0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12        0.6340%                              -11.60                                                 -11.60\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11         0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11         0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12         0.6780%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12         0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile                                                        -250.00                                   -250.00\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee2PartTwo = 
			"AHV-Basis                                                                           12'327.60    15'714.45                                  28'042.05\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                            10'927.60    14'314.45                                  25'242.05\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig                                                                  1'400.00     1'400.00                                   2'800.00\r\n" + 
			"\r\n" + 
			"ALV-Lohn                   126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                  315'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                 12'327.60    15'714.45                                  28'042.05\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                           12'327.60    15'714.45                                  28'042.05\r\n" + 
			"\r\n" + 
			"UVG-Lohn                   126'000.00                                               10'500.00     9'450.00                                  19'950.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                    Personengruppe 1                      12'327.60    15'714.45                                  28'042.05\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11               126'000.00             Code 11                                         9'450.00                                   9'450.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12               300'000.00             Code 12                            1'827.60                                                1'827.60\r\n" + 
			"\r\n" + 
			"KTG-Basis                                     Personengruppe 1                      12'327.60    15'714.45                                  28'042.05\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                500'000.00             Code 12\r\n" + 
			"";
	
	static String employee1PartOne = 
			"1000           Monatslohn                                                            73'000.00    73'000.00    73'000.00     73'000.00      292'000.00\r\n" + 
			"\r\n" + 
			"1005           Stundenlohn\r\n" + 
			"\r\n" + 
			"1006           Lektionenlohn\r\n" + 
			"\r\n" + 
			"1010           Honorare                                                               3'000.00     1'500.00     5'000.00       500.00        10'000.00\r\n" + 
			"\r\n" + 
			"1033           Ortszulage\r\n" + 
			"\r\n" + 
			"1061           Ueberstunden 125%\r\n" + 
			"\r\n" + 
			"1065           Ueberzeit\r\n" + 
			"\r\n" + 
			"1071           Pikettentschädigung\r\n" + 
			"\r\n" + 
			"1073           Sonntagszulage\r\n" + 
			"\r\n" + 
			"1160           Ferienvergütung\r\n" + 
			"\r\n" + 
			"1161           Feiertagsentschädigung\r\n" + 
			"\r\n" + 
			"1200           13. Monatslohn\r\n" + 
			"\r\n" + 
			"1201           Gratifikation\r\n" + 
			"\r\n" + 
			"1212           Sonderzulage                                                           7'000.00    10'000.00     8'000.00     15'000.00       40'000.00\r\n" + 
			"\r\n" + 
			"1230           Dienstaltersgeschenke\r\n" + 
			"\r\n" + 
			"1410           Kapitalleistung mit Vorsorgecharakter                                              45'000.00                                  45'000.00\r\n" + 
			"\r\n" + 
			"1500           Verwaltungsratshonorar\r\n" + 
			"\r\n" + 
			"1900           Gratisverpflegung\r\n" + 
			"\r\n" + 
			"1902           Gratiswohnung\r\n" + 
			"\r\n" + 
			"1910           Privatanteil Geschäftswagen\r\n" + 
			"\r\n" + 
			"1950           Verbilligung Mietwohnung\r\n" + 
			"\r\n" + 
			"1961           Arbeitnehmeraktien                                                    30'000.00                 -30'000.00\r\n" + 
			"\r\n" + 
			"1962           Mitarbeiteroptionen\r\n" + 
			"\r\n" + 
			"1971           Vom AG übern. AN-Anteil KTG\r\n" + 
			"\r\n" + 
			"1972           Vom AG übern. AN-Anteil BVG\r\n" + 
			"\r\n" + 
			"1973           Vom AG übern. AN-Anteil Einkauf BVG\r\n" + 
			"\r\n" + 
			"1976           Vom Arbeitgeber übern. Säule 3 b\r\n" + 
			"\r\n" + 
			"1977           Vom Arbeitgeber übern. Säule 3 a\r\n" + 
			"\r\n" + 
			"1980           Weiterbildung (Lohnausweis)\r\n" + 
			"\r\n" + 
			"2000           EO-Taggeld\r\n" + 
			"\r\n" + 
			"2005           Militärdienstkasse (MDK)\r\n" + 
			"\r\n" + 
			"2030           Unfall-Taggeld\r\n" + 
			"\r\n" + 
			"2035           Kranken-Taggeld\r\n" + 
			"\r\n" + 
			"2050           Korrektur Taggelder\r\n" + 
			"\r\n" + 
			"2060           Lohnabzug KA/SW (ML)\r\n" + 
			"\r\n" + 
			"2065           Lohnausfall KA/SW (SL)\r\n" + 
			"\r\n" + 
			"2070           ALV-Entschädigung\r\n" + 
			"\r\n" + 
			"2075           Karenztag KA/SW\r\n" + 
			"\r\n" + 
			"3000           Kinderzulage                                                            250.00        450.00       450.00       200.00         1'350.00\r\n" + 
			"\r\n" + 
			"3032           Geburtszulage                                                                       1'000.00                                   1'000.00\r\n" + 
			"\r\n" + 
			"6000           Reisespesen\r\n" + 
			"\r\n" + 
			"6020           Effektive Spesen Expatriates\r\n" + 
			"\r\n" + 
			"6040           Pauschale Repräsentationsspesen\r\n" + 
			"\r\n" + 
			"6050           Pauschale Autospesen\r\n" + 
			"\r\n" + 
			"6070           Uebrige Pauschalspesen\r\n" + 
			"\r\n" + 
			"5000           Bruttolohn                                                           113'250.00   130'950.00    56'450.00    88'700.00       389'350.00\r\n" + 
			"\r\n" + 
			"5010           AHV-Beitrag                         5.1500%                           -5'819.50    -4'351.75     -2'884.00    -4'557.75       -17'613.00\r\n" + 
			"\r\n" + 
			"5020           ALV-Beitrag                         1.1000%                             -231.00      -115.50      -808.50      -231.00         -1'386.00\r\n" + 
			"\r\n" + 
			"5030           ALVZ-Beitrag                        0.5000%                             -157.50       -78.75      -506.25      -202.50          -945.00\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT A                   1.4600%\r\n" + 
			"\r\n" + 
			"5040           NBUV-Beitrag BT B                   1.6200%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Männer Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5041           UVGZ-Beitrag Frauen Code 11         0.2010%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Männer Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5042           UVGZ-Beitrag Frauen Code 12         0.6340%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Männer Code 11          0.5430%\r\n" + 
			"\r\n" + 
			"5045           KTG-Beitrag Frauen Code 11          0.6100%\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Männer Code 12          0.6780%                             -465.35      -232.65      -522.40      -500.35         -1'720.75\r\n" + 
			"\r\n" + 
			"5046           KTG-Beitrag Frauen Code 12          0.7200%\r\n" + 
			"\r\n" + 
			"5050           BVG-Beitrag                                                           -5'400.00    -5'400.00     -5'400.00    -5'400.00       -21'600.00\r\n" + 
			"\r\n" + 
			"5051           BVG-Einkaufs-Beiträge                                                -10'000.00                                               -10'000.00\r\n" + 
			"\r\n" + 
			"5080           Abzug Privatanteil Geschäftwagen                                        -500.00      -500.00      -500.00      -500.00         -2'000.00\r\n" + 
			"\r\n" + 
			"5100           Ausgleich Naturalleistungen\r\n" + 
			"\r\n" + 
			"5110           Ausgleich geldwerte Vorteile                                         -30'000.00                 30'000.00\r\n" + 
			"\r\n" + 
			"5111           Ausgleich BVG-Beiträge AG\r\n" + 
			"\r\n" + 
			"5112           Ausgleich BVG-Einkauf AG\r\n" + 
			"";

	static String employee1PartTwo = 
			"AHV-Basis                                                                           113'000.00    84'500.00    56'000.00    88'500.00       342'000.00\r\n" + 
			"\r\n" + 
			"AHV-Lohn                                                                            113'000.00    84'500.00    56'000.00    88'500.00       342'000.00\r\n" + 
			"\r\n" + 
			"Nicht AHV-pflichtig\r\n" + 
			"\r\n" + 
			"ALV-Lohn                    126'000.00                                               21'000.00    10'500.00    73'500.00    21'000.00       126'000.00\r\n" + 
			"\r\n" + 
			"ALVZ-Lohn                   315'000.00                                               31'500.00    15'750.00   101'250.00    40'500.00       189'000.00\r\n" + 
			"\r\n" + 
			"Nicht ALV-pflichtig                                                                  60'500.00    58'250.00  -118'750.00    27'000.00        27'000.00\r\n" + 
			"\r\n" + 
			"UVG-Basis                                                                           113'000.00    84'500.00    56'000.00    88'500.00       342'000.00\r\n" + 
			"\r\n" + 
			"UVG-Lohn                    126'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Basis                                     Personengruppe 1                     113'000.00    84'500.00    56'000.00    88'500.00       342'000.00\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 11                126'000.00             Code 11\r\n" + 
			"\r\n" + 
			"UVGZ-Lohn 12                300'000.00             Code 12\r\n" + 
			"\r\n" + 
			"KTG-Basis                                      Personengruppe 1                     113'000.00    84'500.00    56'000.00    88'500.00       342'000.00\r\n" + 
			"\r\n" + 
			"KTG-Lohn 11                 120'000.00             Code 11\r\n" + 
			"\r\n" + 
			"KTG-Lohn 12                 500'000.00             Code 12                           68'633.35    34'316.65    77'050.00    73'800.00       253'800.00\r\n" + 
			"";
	
	public static void main(String[] args) throws IOException {
		boolean shouldShowDuplicate = false;
		System.err.println("Employee 1: ===================================================================");
		ReadCalculationFile.readPartOne(employee1PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee1PartTwo, shouldShowDuplicate);
		System.err.println("Employee 2: ===================================================================");
		ReadCalculationFile.readPartOne(employee2PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee2PartTwo, shouldShowDuplicate);
		System.err.println("Employee 3: ===================================================================");
		ReadCalculationFile.readPartOne(employee3PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee3PartTwo, shouldShowDuplicate);
		System.err.println("Employee 4: ===================================================================");
		ReadCalculationFile.readPartOne(employee4PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee4PartTwo, shouldShowDuplicate);
		System.err.println("Employee 5: ===================================================================");
		ReadCalculationFile.readPartOne(employee5PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee5PartTwo, shouldShowDuplicate);
		System.err.println("Employee 6: ===================================================================");
		ReadCalculationFile.readPartOne(employee6PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee6PartTwo, shouldShowDuplicate);
		System.err.println("Employee 7: ===================================================================");
		ReadCalculationFile.readPartOne(employee7PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee7PartTwo, shouldShowDuplicate);
		System.err.println("Employee 8: ===================================================================");
		ReadCalculationFile.readPartOne(employee8PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee8PartTwo, shouldShowDuplicate);
		System.err.println("Employee 9: ===================================================================");
		ReadCalculationFile.readPartOne(employee9PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee9PartTwo, shouldShowDuplicate);
		System.err.println("Employee 10: ===================================================================");
		ReadCalculationFile.readPartOne(employee10PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee10PartTwo, shouldShowDuplicate);
		System.err.println("Employee 11: ===================================================================");
		ReadCalculationFile.readPartOne(employee11PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee11PartTwo, shouldShowDuplicate);
		System.err.println("Employee 12: ===================================================================");
		ReadCalculationFile.readPartOne(employee12PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee12PartTwo, shouldShowDuplicate);
		System.err.println("Employee 13: ===================================================================");
		ReadCalculationFile.readPartOne(employee13PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee13PartTwo, shouldShowDuplicate);
		System.err.println("Employee 14: ===================================================================");
		ReadCalculationFile.readPartOne(employee14PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee14PartTwo, shouldShowDuplicate);
		System.err.println("Employee 15: ===================================================================");
		ReadCalculationFile.readPartOne(employee15PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee15PartTwo, shouldShowDuplicate);
		System.err.println("Employee 16: ===================================================================");
		ReadCalculationFile.readPartOne(employee16PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee16PartTwo, shouldShowDuplicate);
		System.err.println("Employee 17: ===================================================================");
		ReadCalculationFile.readPartOne(employee17PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee17PartTwo, shouldShowDuplicate);
		System.err.println("Employee 18: ===================================================================");
		ReadCalculationFile.readPartOne(employee18PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee18PartTwo, shouldShowDuplicate);
		System.err.println("Employee 19: ===================================================================");
		ReadCalculationFile.readPartOne(employee19PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee19PartTwo, shouldShowDuplicate);
		System.err.println("Employee 20: ===================================================================");
		ReadCalculationFile.readPartOne(employee20PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee20PartTwo, shouldShowDuplicate);
		System.err.println("Employee 21: ===================================================================");
		ReadCalculationFile.readPartOne(employee21PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee21PartTwo, shouldShowDuplicate);
		System.err.println("Employee 22: ===================================================================");
		ReadCalculationFile.readPartOne(employee22PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee22PartTwo, shouldShowDuplicate);
		System.err.println("Employee 23: ===================================================================");
		ReadCalculationFile.readPartOne(employee23PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee23PartTwo, shouldShowDuplicate);
		System.err.println("Employee 24: ===================================================================");
		ReadCalculationFile.readPartOne(employee24PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee24PartTwo, shouldShowDuplicate);
		System.err.println("Employee 25: ===================================================================");
		ReadCalculationFile.readPartOne(employee25PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee25PartTwo, shouldShowDuplicate);
		System.err.println("Employee 26: ===================================================================");
		ReadCalculationFile.readPartOne(employee26PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee26PartTwo, shouldShowDuplicate);
		System.err.println("Employee 27: ===================================================================");
		ReadCalculationFile.readPartOne(employee27PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee27PartTwo, shouldShowDuplicate);
		System.err.println("Employee 28: ===================================================================");
		ReadCalculationFile.readPartOne(employee28PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee28PartTwo, shouldShowDuplicate);
		System.err.println("Employee 29: ===================================================================");
		ReadCalculationFile.readPartOne(employee29PartOne, shouldShowDuplicate);
		ReadCalculationFile.readPartTwo(employee29PartTwo, shouldShowDuplicate);
	}
	
	private static void readPartTwo(String partTwoText, boolean shouldShowDuplicate) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(partTwoText.getBytes());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = reader.readLine()) != null) {
			String code = "";
			String germanName = "";
			String duration1 = "";
			String duration2 = "";
			String duration3 = "";
			String duration4 = "";
			if (!line.isEmpty() && line.trim().length() >= PART_2_END_COL_1 + 1) {
				germanName = readPartTwoFirstColumn(line);
				if (line.length() > PART_2_END_COL_2 + 1) {
					duration1 = readPartTwoSecondColumn(line);
				}
				if (line.length() > PART_2_END_COL_3 + 1) {
					duration2 = readPartTwoThirdColumn(line);
				}
				if (line.length() > PART_2_END_COL_4 + 1) {
					duration3 = readPartTwoForthColumn(line);
				}
				if (line.length() > PART_2_END_COL_5 + 1) {
					duration4 = readPartTwoFifthColumn(line);
				}
				
				code = fillTextWithSpace(SalaryItemTypeName.fromGermanNameToCode(germanName.trim()), COL_1_LENGTH);
				String englishCodeName = !germanName.isEmpty() ? SalaryItemTypeName.fromGermanName(germanName.trim()) : "";
				englishCodeName = fillTextWithSpace(englishCodeName, COL_2_LENGTH);
				duration1 = fillTextWithSpace(duration1, COL_3_LENGTH);
				duration2 = fillTextWithSpace(duration2, COL_4_LENGTH);
				duration3 = fillTextWithSpace(duration3, COL_5_LENGTH);
				duration4 = fillTextWithSpace(duration4, COL_6_LENGTH);
				
				if (!shouldShowDuplicate) {
					if (!duration1.trim().isEmpty() || !duration2.trim().isEmpty() || !duration3.trim().isEmpty() || !duration4.trim().isEmpty()) {
						System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1, duration2, duration3,
								duration4);
					}
				} else {
					System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1, duration2, duration3,
							duration4);
				}
			}
		}
	}

	public static void readPartOne(String partOneText, boolean shouldShowDuplicate) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(partOneText.getBytes());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = reader.readLine()) != null) {
			String code = "";
			String germanName = "";
			String duration1 = "";
			String duration2 = "";
			String duration3 = "";
			String duration4 = "";
			if (!line.isEmpty() && line.trim().length() >= PART_1_END_COL_1 + 1) {
				code = readPartOneFirstColumn(line);
				if (line.length() > PART_1_END_COL_2 + 1) {
					germanName = readPartOneSecondColumn(line);
				}
				if (line.length() > PART_1_END_COL_3 + 1) {
					duration1 = readPartOneThirdColumn(line);
				}
				if (line.length() > PART_1_END_COL_4 + 1) {
					duration2 = readPartOneForthColumn(line);
				}
				if (line.length() > PART_1_END_COL_5 + 1) {
					duration3 = readPartOneFifthColumn(line);
				}
				if (line.length() > PART_1_END_COL_6 + 1) {
					duration4 = readPartOneSixthColumn(line);
				}
				
				code = fillTextWithSpace(code, COL_1_LENGTH);
				String englishCodeName = !germanName.isEmpty() ? SalaryItemTypeName.fromGermanName(germanName.trim()) : "";
				englishCodeName = fillTextWithSpace(englishCodeName, COL_2_LENGTH);
				duration1 = fillTextWithSpace(duration1, COL_3_LENGTH);
				duration2 = fillTextWithSpace(duration2, COL_4_LENGTH);
				duration3 = fillTextWithSpace(duration3, COL_5_LENGTH);
				duration4 = fillTextWithSpace(duration4, COL_6_LENGTH);
				
				if (!shouldShowDuplicate) {
					if (!duration1.trim().isEmpty() || !duration2.trim().isEmpty() || !duration3.trim().isEmpty() || !duration4.trim().isEmpty()) {
						System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1, duration2, duration3,
								duration4);
					}
				} else {
					System.out.format("| %s | %s | %s | %s | %s | %s | \r\n", code, englishCodeName, duration1, duration2, duration3,
							duration4);
				}
			}
		}
	}
	
	private static String readPartOneFirstColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_1, PART_1_END_COL_1);
	}
	
	private static String readPartOneSecondColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_2, PART_1_END_COL_2);
	}
	
	private static String readPartOneThirdColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_3, PART_1_END_COL_3);
	}
	
	private static String readPartOneForthColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_4, PART_1_END_COL_4);
	}
	
	private static String readPartOneFifthColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_5, PART_1_END_COL_5);
	}
	
	private static String readPartOneSixthColumn(String line) {
		return extractLineByPosition(line, PART_1_START_COL_6, PART_1_END_COL_6);
	}
	
	private static String readPartTwoFirstColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_1, PART_2_END_COL_1);
	}
	
	private static String readPartTwoSecondColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_2, PART_2_END_COL_2);
	}
	
	private static String readPartTwoThirdColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_3, PART_2_END_COL_3);
	}
	
	private static String readPartTwoForthColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_4, PART_2_END_COL_4);
	}
	
	private static String readPartTwoFifthColumn(String line) {
		return extractLineByPosition(line, PART_2_START_COL_5, PART_2_END_COL_5);
	}
	
	private static String extractLineByPosition(String line, int start, int end) {
		return line.substring(start, end);
	}
	
	public static String fillTextWithSpace(String text, int lengthToFill) {
		String filledText = text.trim();
		if (text.trim().length() < lengthToFill) {
			for (int i = 0; i < lengthToFill - text.trim().length(); i ++) {
				filledText += " ";
			}
		}
		return filledText;
	}

}
