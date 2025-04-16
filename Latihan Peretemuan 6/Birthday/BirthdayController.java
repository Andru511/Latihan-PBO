package Birthday;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class BirthdayController {
    private BirthdayGUI view;
    
    public BirthdayController(BirthdayGUI view){
        this.view = view;
        
        this.view.calculateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = view.nameField.getText().trim();
                String dateText = view.dateField.getText().trim();
                
                try{
                    LocalDate birthDate = LocalDate.parse(dateText);
                    Person person = new Person(name, birthDate);
                    view.resultArea.setText(calculateInfo(person));
                }
                catch (Exception EX){
                    view.resultArea.setText("Format tanggal salah. Coba format yyyy-mm-dd");
                }                   
            }
        });
        
    }
    
    private String calculateInfo(Person person){
        LocalDate today = LocalDate.now();
        LocalDate birthDate = person.getBirthDate();
        
        Period age = Period.between(birthDate, today);
        
        LocalDate nextBirthday = birthDate.withYear(today.getYear());
        
        if(nextBirthday.isBefore(today) || nextBirthday.isEqual(today)){
            nextBirthday = nextBirthday.plusYears(1);
        }
        
        long daysToNextBirthday = Duration.between(today.atStartOfDay(), nextBirthday.atStartOfDay()).toDays();
    return String.format("""
                         Halo %s!
                         Umurmu Saat ini: %d tahun, %d bulan, %d hari.
                         Ulang tahun berikutnya dalam %d hari lagi!
                         """, person.getName(), age.getYears(), age.getMonths(), age.getDays(), daysToNextBirthday);
    }
    
}