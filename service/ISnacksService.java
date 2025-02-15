package snacks_machine_files.service;

import snacks_machine_files.domain.Snack;

import java.util.List;

public interface ISnacksService {
    void addSnack(Snack snack);
    void showSnacks();
    List <Snack> getSnacks();
}
