//package car.shop.dto;
//
//import car.shop.entity.Completion;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString(exclude = "completions")
//public class LayoutDto {
//
//    private UUID id;
//
//    private String layoutName;
//
//    private UUID completionId;
//
////    private List<Completion> completions;
//
////    private List<Completion> completions = new ArrayList<Completion>(); // инициализируем список
//    private List<Completion> completions = new ArrayList<>(); // инициализируем список
////    public void setCompletions(List<Completion> completions) {
////        this.completions = new ArrayList<Completion> (completions); // копируем список
////    }
//}

package car.shop.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@ToString(exclude = "completions")
public class LayoutDto {

    private UUID id;

    private String layoutName;

    private UUID completionId;

    private List<CompletionDto> completions = new ArrayList<>();
}