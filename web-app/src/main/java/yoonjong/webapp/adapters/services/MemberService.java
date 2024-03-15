package yoonjong.webapp.adapters.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.models.MemberModel;
import yoonjong.core.domains.member.usecases.GetMemberUseCase;
import yoonjong.core.domains.member.usecases.SaveMemberUseCase;
import yoonjong.webapp.dtos.Member.CreateMemberDto;
import yoonjong.webapp.dtos.Member.LoginDto;
import yoonjong.webapp.dtos.Member.MemberSimpleDto;

@Component
@RequiredArgsConstructor
public class MemberService {
    private final GetMemberUseCase getMemberUseCase;
    private final SaveMemberUseCase saveMemberUseCase;

    public MemberSimpleDto CreateMember(CreateMemberDto createContext) {
        MemberModel member = saveMemberUseCase.CreateMember(createContext.getEmail(), createContext.getPassword(), createContext.getName());
        if(member == null)
            return null;

        return new MemberSimpleDto(member);
    }

    public MemberSimpleDto Login(LoginDto loginDto){ //entity객체는 service에서만
        MemberModel member = getMemberUseCase.Login(loginDto.getEmail(),loginDto.getPassword());
        if(member == null)
            return null;

        return new MemberSimpleDto(member);
    }
}
