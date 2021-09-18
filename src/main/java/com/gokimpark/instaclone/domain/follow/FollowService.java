package com.gokimpark.instaclone.domain.follow;

import com.gokimpark.instaclone.domain.exception.UserException;
import com.gokimpark.instaclone.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public void addFollow(User toUser, User fromUser){

        try{
            followRepository.save(Follow.builder()
                    .toUser(toUser.getId())
                    .fromUser(fromUser.getId())
                    .build());
        } catch (Exception e){
            throw new UserException("이미 팔로우함.");
        }
    }

    public void unFollow(Integer toUserId, Integer fromUserId){

        Optional<Follow> follow = followRepository.findByToUserAndFromUser(toUserId, fromUserId);
        if(!follow.isEmpty()) followRepository.delete(follow.get());
    }

    public List<User> getFollowingList(Integer userId){
        return followRepository.findAllByFromUser(userId);
    }

    public String getFollowingCount(Integer user){
        Long count = followRepository.countByFromUser(user);
        return chgToStr(count);
    }

    public List<User> getFollowerList(Integer userId){
        return followRepository.findAllByToUser(userId);
    }

    public String getFollowerCount(Integer user){
        Long count = followRepository.countByToUser(user);
        return chgToStr(count);
    }

    public Pair<String, String> getProfileFollowCount(Integer userId){
        String followerCount = getFollowerCount(userId);
        String followingCount = getFollowingCount(userId);
        return Pair.of(followerCount, followingCount);
    }

    public void deleteFollowRelation(Integer userId){
        followRepository.deleteAllByFromUser(userId);
        followRepository.deleteAllByToUser(userId);
    }

    public String chgToStr(Long count){
        // 변경 예정
        return String.valueOf(count);
    }

}
