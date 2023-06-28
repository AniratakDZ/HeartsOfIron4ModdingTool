package data.objects.technology.technologyTree;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Technology extends GameObject {

    private String name;
    private List<TechnologyPath> technologyPaths;
    private double researchCost;
    private double productionFactoryMaxEfficiencyFactor;
    private int startYear;
    private TechnologyFolder folder;
    private TechnologyAiWillDo aiWillDo;
    private TechnologyCategories categories;
    private double lineChangeProductionEfficiencyFactor;
    private double productionFactoryEfficiencyGainFactor;
    private double equipmentConversionSpeed;
    private TechnologyXOR xor;
    private TechnologyAllowBranch allowBranch;
    private double industrialCapacityFactory;
    private double industrialCapacityDockyard;
    private double globalBuildingSlotsFactor;
    private TechnologyAiResearchWeights aiResearchWeights;
    private double productionFactoryStartEfficiencyFactor;
    private double industryAirDamageFactor;
    private TechnologyEnableBuilding enableBuilding;
    private double fuelGainFactor;
    private double fuelGainFactorFromState;
    private boolean showEffectAsDesc;
    private TechnologyOnResearchComplete onResearchComplete;
    private double productionSpeedBuildingsFactor;
    private double industryRepairFactor;
    private double localResourcesFactor;
    private String doctrineName;
    private double airSuperiorityDetectFactor;
    private String xpResearchType;
    private int xpUnlockCost;
    private boolean doctrine;
    private double airCasPresentFactor;
    private double airInterceptionDetectFactor;
    private double airNavEfficiency;
    private double airInterceptEfficiency;
    private double airMissionXpGainFactor;
    private double airSuperiorityEfficiency;
    private TechnologyEquipmentBonus equipmentBonus;
    private double armyBonusAirSuperiorityFactor;
    private double airStrategicBomberNightPenalty;
    private double airStrategicBomberBombingFactor;
    private double airEscortEfficiency;
    private double airStrategicBomberDefenseFactor;
    private double airCasEfficiency;
    private double airAceGenerationChanceFactor;

    public Technology() {
        technologyPaths = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TechnologyPath> getTechnologyPaths() {
        return technologyPaths;
    }

    public void setTechnologyPaths(List<TechnologyPath> technologyPaths) {
        this.technologyPaths = technologyPaths;
    }

    public double getResearchCost() {
        return researchCost;
    }

    public void setResearchCost(double researchCost) {
        this.researchCost = researchCost;
    }

    public double getProductionFactoryMaxEfficiencyFactor() {
        return productionFactoryMaxEfficiencyFactor;
    }

    public void setProductionFactoryMaxEfficiencyFactor(double productionFactoryMaxEfficiencyFactor) {
        this.productionFactoryMaxEfficiencyFactor = productionFactoryMaxEfficiencyFactor;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public TechnologyFolder getFolder() {
        return folder;
    }

    public void setFolder(TechnologyFolder folder) {
        this.folder = folder;
    }

    public TechnologyAiWillDo getAiWillDo() {
        return aiWillDo;
    }

    public void setAiWillDo(TechnologyAiWillDo aiWillDo) {
        this.aiWillDo = aiWillDo;
    }

    public TechnologyCategories getCategories() {
        return categories;
    }

    public void setCategories(TechnologyCategories categories) {
        this.categories = categories;
    }

    public double getLineChangeProductionEfficiencyFactor() {
        return lineChangeProductionEfficiencyFactor;
    }

    public void setLineChangeProductionEfficiencyFactor(double lineChangeProductionEfficiencyFactor) {
        this.lineChangeProductionEfficiencyFactor = lineChangeProductionEfficiencyFactor;
    }

    public double getProductionFactoryEfficiencyGainFactor() {
        return productionFactoryEfficiencyGainFactor;
    }

    public void setProductionFactoryEfficiencyGainFactor(double productionFactoryEfficiencyGainFactor) {
        this.productionFactoryEfficiencyGainFactor = productionFactoryEfficiencyGainFactor;
    }

    public double getEquipmentConversionSpeed() {
        return equipmentConversionSpeed;
    }

    public void setEquipmentConversionSpeed(double equipmentConversionSpeed) {
        this.equipmentConversionSpeed = equipmentConversionSpeed;
    }

    public TechnologyXOR getXor() {
        return xor;
    }

    public void setXor(TechnologyXOR xor) {
        this.xor = xor;
    }

    public TechnologyAllowBranch getAllowBranch() {
        return allowBranch;
    }

    public void setAllowBranch(TechnologyAllowBranch allowBranch) {
        this.allowBranch = allowBranch;
    }

    public double getIndustrialCapacityFactory() {
        return industrialCapacityFactory;
    }

    public void setIndustrialCapacityFactory(double industrialCapacityFactory) {
        this.industrialCapacityFactory = industrialCapacityFactory;
    }

    public double getIndustrialCapacityDockyard() {
        return industrialCapacityDockyard;
    }

    public void setIndustrialCapacityDockyard(double industrialCapacityDockyard) {
        this.industrialCapacityDockyard = industrialCapacityDockyard;
    }

    public double getGlobalBuildingSlotsFactor() {
        return globalBuildingSlotsFactor;
    }

    public void setGlobalBuildingSlotsFactor(double globalBuildingSlotsFactor) {
        this.globalBuildingSlotsFactor = globalBuildingSlotsFactor;
    }

    public TechnologyAiResearchWeights getAiResearchWeights() {
        return aiResearchWeights;
    }

    public void setAiResearchWeights(TechnologyAiResearchWeights aiResearchWeights) {
        this.aiResearchWeights = aiResearchWeights;
    }

    public double getProductionFactoryStartEfficiencyFactor() {
        return productionFactoryStartEfficiencyFactor;
    }

    public void setProductionFactoryStartEfficiencyFactor(double productionFactoryStartEfficiencyFactor) {
        this.productionFactoryStartEfficiencyFactor = productionFactoryStartEfficiencyFactor;
    }

    public double getIndustryAirDamageFactor() {
        return industryAirDamageFactor;
    }

    public void setIndustryAirDamageFactor(double industryAirDamageFactor) {
        this.industryAirDamageFactor = industryAirDamageFactor;
    }

    public TechnologyEnableBuilding getEnableBuilding() {
        return enableBuilding;
    }

    public void setEnableBuilding(TechnologyEnableBuilding enableBuilding) {
        this.enableBuilding = enableBuilding;
    }

    public double getFuelGainFactor() {
        return fuelGainFactor;
    }

    public void setFuelGainFactor(double fuelGainFactor) {
        this.fuelGainFactor = fuelGainFactor;
    }

    public double getFuelGainFactorFromState() {
        return fuelGainFactorFromState;
    }

    public void setFuelGainFactorFromState(double fuelGainFactorFromState) {
        this.fuelGainFactorFromState = fuelGainFactorFromState;
    }

    public boolean isShowEffectAsDesc() {
        return showEffectAsDesc;
    }

    public void setShowEffectAsDesc(boolean showEffectAsDesc) {
        this.showEffectAsDesc = showEffectAsDesc;
    }

    public TechnologyOnResearchComplete getOnResearchComplete() {
        return onResearchComplete;
    }

    public void setOnResearchComplete(TechnologyOnResearchComplete onResearchComplete) {
        this.onResearchComplete = onResearchComplete;
    }

    public double getProductionSpeedBuildingsFactor() {
        return productionSpeedBuildingsFactor;
    }

    public void setProductionSpeedBuildingsFactor(double productionSpeedBuildingsFactor) {
        this.productionSpeedBuildingsFactor = productionSpeedBuildingsFactor;
    }

    public double getIndustryRepairFactor() {
        return industryRepairFactor;
    }

    public void setIndustryRepairFactor(double industryRepairFactor) {
        this.industryRepairFactor = industryRepairFactor;
    }

    public double getLocalResourcesFactor() {
        return localResourcesFactor;
    }

    public void setLocalResourcesFactor(double localResourcesFactor) {
        this.localResourcesFactor = localResourcesFactor;
    }
}
