//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    AutoShop<Volvo240> volvoAutoShop = new AutoShop(2);
    AutoShop<Car> autoShop = new AutoShop<>(2);
    volvoAutoShop.loadCar(new Volvo240());
    autoShop.loadCar(new Biltransport(1));
    autoShop.loadCar(new Volvo240());

}
