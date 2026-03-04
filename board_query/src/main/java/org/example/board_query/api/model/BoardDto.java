package org.example.board_query.api.model;

import lombok.Builder;
import lombok.Getter;

public class BoardDto {
    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String title;
        private String writer;
        private int replyCount;
        private int likeslist;

        public static ListRes from(Board entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .writer(entity.getUser().getName())
                    .likeslist(entity.getLikesList().size())
                    .replyCount(entity.getReply().size())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ReadRes {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private int likeslist;

        public static ReadRes from(Board entity) {
            return ReadRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .content(entity.getContents())
                    .writer(entity.getUserName())
                    .build();
        }
    }
}
