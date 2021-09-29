package com.gokimpark.instaclone.web.user.dto;

import com.gokimpark.instaclone.domain.post.dto.PostProfileDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProfileDto {

    ProfileUserInfoDto userInfo;
    List<PostProfileDto> posts;
    List<ProfileStoryDto> stories;
}