public class PersonalComputer {
    String NameOfModel_PersonalComputer;
    double Size_Monitor;
    String TypeOfConnector_Keyboard;

    public String getNameOfModel_PersonalComputer() {
        return NameOfModel_PersonalComputer;
    }

    public void setNameOfModel_PersonalComputer(String nameOfModel_PersonalComputer) {
        NameOfModel_PersonalComputer = nameOfModel_PersonalComputer;
    }

    public double getSize_Monitor() {
        return Size_Monitor;
    }

    public void setSize_Monitor(double size_Monitor) {
        Size_Monitor = size_Monitor;
    }

    public String getTypeOfConnector_Keyboard() {
        return TypeOfConnector_Keyboard;
    }

    public void setTypeOfConnector_Keyboard(String typeOfConnector_Keyboard) {
        TypeOfConnector_Keyboard = typeOfConnector_Keyboard;
    }

    public int getNumberOfMouseButtons_Mouse() {
        return NumberOfMouseButtons_Mouse;
    }

    public void setNumberOfMouseButtons_Mouse(int numberOfMouseButtons_Mouse) {
        NumberOfMouseButtons_Mouse = numberOfMouseButtons_Mouse;
    }

    public String getTypeOfConnector_Mouse() {
        return TypeOfConnector_Mouse;
    }

    public void setTypeOfConnector_Mouse(String typeOfConnector_Mouse) {
        TypeOfConnector_Mouse = typeOfConnector_Mouse;
    }

    public double getStorage_HardDisk() {
        return Storage_HardDisk;
    }

    public void setStorage_HardDisk(double storage_HardDisk) {
        Storage_HardDisk = storage_HardDisk;
    }

    public double getRotationalSpeed_HardDisk() {
        return RotationalSpeed_HardDisk;
    }

    public void setRotationalSpeed_HardDisk(double rotationalSpeed_HardDisk) {
        RotationalSpeed_HardDisk = rotationalSpeed_HardDisk;
    }

    public int getNumberOfBays_Chassis() {
        return NumberOfBays_Chassis;
    }

    public void setNumberOfBays_Chassis(int numberOfBays_Chassis) {
        NumberOfBays_Chassis = numberOfBays_Chassis;
    }

    public int[] getDimensions_Chassis() {
        return Dimensions_Chassis;
    }

    public void setDimensions_Chassis(int[] dimensions_Chassis) {
        Dimensions_Chassis = dimensions_Chassis;
    }

    public double getPowerSupplyRating_Chassis() {
        return PowerSupplyRating_Chassis;
    }

    public void setPowerSupplyRating_Chassis(double powerSupplyRating_Chassis) {
        PowerSupplyRating_Chassis = powerSupplyRating_Chassis;
    }

    public String getName_Processor() {
        return Name_Processor;
    }

    public void setName_Processor(String name_Processor) {
        Name_Processor = name_Processor;
    }

    public int getProcessorSpeed_Processor() {
        return ProcessorSpeed_Processor;
    }

    public void setProcessorSpeed_Processor(int processorSpeed_Processor) {
        ProcessorSpeed_Processor = processorSpeed_Processor;
    }

    public int getBusSpeed_Processor() {
        return BusSpeed_Processor;
    }

    public void setBusSpeed_Processor(int busSpeed_Processor) {
        BusSpeed_Processor = busSpeed_Processor;
    }

    public String getArchitecture_Memory() {
        return Architecture_Memory;
    }

    public void setArchitecture_Memory(String architecture_Memory) {
        Architecture_Memory = architecture_Memory;
    }

    public int getTheAmountOfMemory_Memory() {
        return TheAmountOfMemory_Memory;
    }

    public void setTheAmountOfMemory_Memory(int theAmountOfMemory_Memory) {
        TheAmountOfMemory_Memory = theAmountOfMemory_Memory;
    }

    public PersonalComputer(String nameOfModel_PersonalComputer,
                            double size_Monitor, String typeOfConnector_Keyboard,
                            int numberOfMouseButtons_Mouse, String typeOfConnector_Mouse,
                            double storage_HardDisk, double rotationalSpeed_HardDisk,
                            int numberOfBays_Chassis, int[] dimensions_Chassis, double powerSupplyRating_Chassis,
                            String name_Processor, int processorSpeed_Processor, int busSpeed_Processor,
                            String architecture_Memory, int theAmountOfMemory_Memory) {
        NameOfModel_PersonalComputer = nameOfModel_PersonalComputer;
        Size_Monitor = size_Monitor;
        TypeOfConnector_Keyboard = typeOfConnector_Keyboard;
        NumberOfMouseButtons_Mouse = numberOfMouseButtons_Mouse;
        TypeOfConnector_Mouse = typeOfConnector_Mouse;
        Storage_HardDisk = storage_HardDisk;
        RotationalSpeed_HardDisk = rotationalSpeed_HardDisk;
        NumberOfBays_Chassis = numberOfBays_Chassis;
        Dimensions_Chassis = dimensions_Chassis;
        PowerSupplyRating_Chassis = powerSupplyRating_Chassis;
        Name_Processor = name_Processor;
        ProcessorSpeed_Processor = processorSpeed_Processor;
        BusSpeed_Processor = busSpeed_Processor;
        Architecture_Memory = architecture_Memory;
        TheAmountOfMemory_Memory = theAmountOfMemory_Memory;
    }

    public PersonalComputer() {
    }

    int NumberOfMouseButtons_Mouse;
    String TypeOfConnector_Mouse;
    double Storage_HardDisk;
    double RotationalSpeed_HardDisk;
    int NumberOfBays_Chassis;
    int[] Dimensions_Chassis = new int[3];
    double PowerSupplyRating_Chassis;
    String Name_Processor;
    int ProcessorSpeed_Processor;
    int BusSpeed_Processor;
    String Architecture_Memory;
    int TheAmountOfMemory_Memory;
}
