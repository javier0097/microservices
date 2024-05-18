package com.example.application.service.model.domain;

final class Constants {

    private Constants() {
    }

    public static class BulletinTable {
        public static final String NAME = "bulletin_table";

        public static class Id {
            public static final String NAME = "bulletinid";
        }

        public static class AccountId {
            public static final String NAME = "accountid";
        }

        public static class SenderUserId {
            public static final String NAME = "senderuserid";
        }

        public static class Body {
            public static final String NAME = "body";

            public static final int LENGTH = 100;
        }

        public static class PostDate {
            public static final String NAME = "postdate";
        }

        public static class IsDeleted {
            public static final String NAME = "isdeleted";
        }

        public static class CommentsCounter {
            public static final String NAME = "commentscounter";
        }

        public static class LikesCounter {
            public static final String NAME = "likescounter";
        }

        public static class CreatedDate {
            public static final String NAME = "createddate";
        }

    }

    public static class CommentTable {
        public static final String NAME = "comment_table";

        public static class Id {
            public static final String NAME = "commentid";
        }

        public static class SenderUserId {
            public static final String NAME = "senderuserid";
        }

        public static class AccountId {
            public static final String NAME = "accountid";
        }

        public static class TextId {
            public static final String NAME = "textid";

            public static final int LENGTH = 100;
        }

        public static class ParentId {
            public static final String NAME = "parentid";
        }

        public static class RepliesCounter {
            public static final String NAME = "repliescounter";
        }

        public static class IsDeleted {
            public static final String NAME = "isDeleted";
        }

        public static class CreatedDate {
            public static final String NAME = "createddate";
        }

        public static class BulletinId {
            public static final String NAME = "bulletinid";
        }
    }

    public static class RateBulletinLikesTable {
        public static final String NAME = "ratebulletinlikes_table";

        public static class Id {
            public static final String NAME = "ratebulletinlikesid";
        }

        public static class AccountId {
            public static final String NAME = "accountid";
        }

        public static class BulletinId {
            public static final String NAME = "bulletinid";
        }

        public static class UserId {
            public static final String NAME = "userid";
        }
    }

    public static class AttachmentTable {
        public static final String NAME = "attachment_table";

        public static class Id {
            public static final String NAME = "attachmentid";
        }

        public static class AccountId {
            public static final String NAME = "accountid";
        }

        public static class FileId {
            public static final String NAME = "fileid";

            public static final int LENGTH = 100;
        }

        public static class IsDeleted {
            public static final String NAME = "isdeleted";
        }

        public static class CreatedDate {
            public static final String NAME = "createddate";
        }

        public static class BulletinId {
            public static final String NAME = "bulletinid";
        }
    }
}