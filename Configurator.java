package com.microblink.ocr;

import com.microblink.recognizers.blinkocr.parser.generic.DateParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.EMailParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.RawParserSettings;

/**
 * Created by vignesh.s on 04/02/2016.
 */
public class Configurator {
    public static ScanConfiguration[] createScanConfigurations() {
        // here we will create scan configuration for  Raw text
        // in Raw text parser we will enable Sieve algorithm which will
        // reuse OCR results from multiple video frames to improve quality

        RawParserSettings rawSett = new RawParserSettings();
        rawSett.setUseSieve(false);

        return new ScanConfiguration[] {
                new ScanConfiguration(R.string.raw_title, R.string.raw_msg, "Raw", rawSett)

        };
       }
}
