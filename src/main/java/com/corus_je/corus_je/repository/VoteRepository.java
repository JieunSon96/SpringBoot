package com.corus_je.corus_je.repository;
import com.corus_je.corus_je.entity.ChoiceVoteCount;
import com.corus_je.corus_je.entity.Voter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface VoteRepository extends JpaRepository<Voter, Long> {
    @Query("SELECT NEW com.corus_je.corus_je.entity.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Voter v WHERE v.poll.id in :pollIds GROUP BY v.choice.id")
    List<ChoiceVoteCount> countByPollIdInGroupByChoiceId(@Param("pollIds") List<Long> pollIds);

    @Query("SELECT NEW com.corus_je.corus_je.entity.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Voter v WHERE v.poll.id = :pollId GROUP BY v.choice.id")
    List<ChoiceVoteCount> countByPollIdGroupByChoiceId(@Param("pollId") Long pollId);

    @Query("SELECT v FROM Voter v where v.user.id = :userId and v.poll.id in :pollIds")
    List<Voter> findByUserIdAndPollIdIn(@Param("userId") Long userId, @Param("pollIds") List<Long> pollIds);

    @Query("SELECT v FROM Voter v where v.user.id = :userId and v.poll.id = :pollId")
    Voter findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);

    @Query("SELECT COUNT(v.id) from Voter v where v.user.id = :userId")
    long countByUserId(@Param("userId") Long userId);

    @Query("SELECT v.poll.id FROM Voter v WHERE v.user.id = :userId")
    Page<Long> findVotedPollIdsByUserId(@Param("userId") Long userId, Pageable pageable);
}