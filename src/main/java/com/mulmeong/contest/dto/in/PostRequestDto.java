package com.mulmeong.contest.dto.in;

import com.mulmeong.contest.entity.MediaType;
import com.mulmeong.contest.entity.Post;
import com.mulmeong.contest.vo.in.PostRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostRequestDto {

    private Long contestId;
    private String memberUuid;
    private String mediaUrl;
    private MediaType mediaType;

    @Builder
    public PostRequestDto(
            Long contestId,
            String memberUuid,
            String mediaUrl,
            MediaType mediaType
    ) {
        this.contestId = contestId;
        this.memberUuid = memberUuid;
        this.mediaUrl = mediaUrl;
        this.mediaType = mediaType;
    }

    public static PostRequestDto toDto(String memberUuid, Long contestId, PostRequestVo requestVo) {
        return PostRequestDto.builder()
                .contestId(contestId)
                .memberUuid(memberUuid)
                .mediaUrl(requestVo.getMediaUrl())
                .mediaType(requestVo.getMediaType())
                .build();
    }

    public Post toEntity() {
        return Post.builder()
                .contestId(contestId)
                .memberUuid(memberUuid)
                .mediaUrl(mediaUrl)
                .mediaType(mediaType)
                .build();
    }
}