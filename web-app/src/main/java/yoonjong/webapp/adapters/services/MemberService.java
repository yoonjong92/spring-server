package yoonjong.webapp.adapters.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.models.Member;
import yoonjong.core.domains.member.usecases.GetMemberUseCase;
import yoonjong.core.domains.member.usecases.SaveMemberUseCase;
import yoonjong.webapp.dtos.Member.CreateMemberDto;
import yoonjong.webapp.dtos.Member.MemberSimpleDto;

@Component
@RequiredArgsConstructor
public class MemberService {
    private final GetMemberUseCase getMemberUseCase;
    private final SaveMemberUseCase saveMemberUseCase;

    public MemberSimpleDto CreateMember(CreateMemberDto createContext) {
        Member model = saveMemberUseCase.CreateMember(createContext.getEmail(), createContext.getPassword(), createContext.getName());
        if(model == null)
            return null;
        
        MemberSimpleDto dto = new MemberSimpleDto();
        dto.setId(model.getId());
        dto.setEmail(model.getEmail());
        dto.setName(model.getName());
        return dto;
    }
}
