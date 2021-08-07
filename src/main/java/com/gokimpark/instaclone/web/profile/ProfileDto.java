package com.gokimpark.instaclone.web.profile;

import lombok.Data;

import java.util.List;

@Data
public class ProfileDto {
    ProfileMemberInfoDto memberInfo;
    List<ProfilePostDto> posts;
    List<ProfileStoryDto> stories;
}