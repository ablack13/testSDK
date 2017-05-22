package com.ablack13.nimbussdk.net.entities.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ablack13 on 22.05.17.
 */

public class UserAuthResponse {
    public int errorCode;
    public Body body;

    public static class Body {
        String sessionid;
        String token;
        public Info info;

        public static class Info {
            public int user_id;
            public String register_date;
            public int days_to_quota_reset;
            public String login;
            public String username;
            public Premium premium;
            public Usage usage;
            public String[] languages;
            public NotesPredefinedFolders notes_predefined_folders;
            public Limits limits;

            public static class Premium {
                public boolean active;
                public String start_date;
                public String end_date;
                public String source;
            }

            public static class Usage {
                public Notes notes;

                public static class Notes {
                    long current;
                    long max;
                }
            }

            public static class NotesPredefinedFolders {
                @SerializedName("default")
                String Default;
                String root;
                String trash;
            }

            public static class Limits {
                long NOTES_MAX_SIZE;
                long NOTES_MONTH_USAGE_QUOTA;
                long NOTES_MAX_ATTACHMENT_SIZE;
            }
        }

    }
}
