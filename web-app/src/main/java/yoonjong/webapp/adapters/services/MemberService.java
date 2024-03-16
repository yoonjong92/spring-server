package yoonjong.webapp.adapters.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.models.MemberModel;
import yoonjong.core.domains.member.usecases.GetMemberUseCase;
import yoonjong.core.domains.member.usecases.SaveMemberUseCase;
import yoonjong.webapp.dtos.Member.CreateMemberDto;
import yoonjong.webapp.dtos.Member.LoginDto;
import yoonjong.webapp.dtos.Member.MemberDto;
import yoonjong.webapp.dtos.Member.MemberSimpleDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberService {
    private final GetMemberUseCase getMemberUseCase;
    private final SaveMemberUseCase saveMemberUseCase;

    public List<MemberSimpleDto> GetList() {
        List<MemberModel> models =  getMemberUseCase.GetAll();
        return models.stream()
                .map(MemberSimpleDto::new)
                .toList();
    }

    public MemberDto GetDetail(long id) {
        MemberModel model = getMemberUseCase.GetMember(id);
        if(model == null)
            return null;

        return new MemberDto(model);
    }

    public MemberSimpleDto CreateMember(CreateMemberDto createContext) {
        MemberModel member = saveMemberUseCase.CreateMember(createContext.getEmail(), createContext.getPassword(), createContext.getName());
        if(member == null)
            return null;

        return new MemberSimpleDto(member);
    }

    public int DeleteMember(long id) {
        saveMemberUseCase.DeleteMember(id);
        // 언래는 지워진 숫자를 리턴해야 함, 일단은 무조건 지웠다고 가정
        return 1;
    }

    public MemberSimpleDto Login(LoginDto loginDto){
        MemberModel member = getMemberUseCase.Login(loginDto.getEmail(),loginDto.getPassword());
        if(member == null)
            return null;

        return new MemberSimpleDto(member);
    }
}
