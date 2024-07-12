package org.corpauration.personnal_library;

import java.sql.Timestamp;

public class time_manipulation {


    public static Long timestamp_to_long(Timestamp timestamp) {
        return timestamp.getTime();
    }

}
