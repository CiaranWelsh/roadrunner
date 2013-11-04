/*
 * GetValuesCodeGen.cpp
 *
 *  Created on: Sept 16, 2013
 *      Author: andy
 */
#pragma hdrstop
#include "SetInitialValuesCodeGen.h"
#include "LLVMException.h"
#include "ModelDataSymbolResolver.h"
#include "rrLogger.h"

#include <Poco/Logger.h>
#include <vector>
#include <algorithm>

using namespace llvm;
using namespace std;



namespace rrllvm
{

/**
 * C++ 11 has the copy_if template, but for the time being, we need to be
 * compatible with older C++, so use our own filtering here.
 */
static std::vector<std::pair<uint, std::string> > independentElements(const LLVMModelDataSymbols &dataSymbols,
        const std::vector<string> elements)
{
    std::vector<std::pair<uint, std::string> > result;

    for(std::vector<string>::const_iterator i = elements.begin();
            i != elements.end(); ++i)
    {
        if (dataSymbols.isIndependentInitElement(*i) || dataSymbols.isConservedMoiety(*i))
        {
            pair<uint, string> value(i - elements.begin(), dataSymbols.getInitSymbol(*i));
            result.push_back(value);
        }
    }

    return result;
}



const char* SetFloatingSpeciesInitConcentrationsCodeGen::FunctionName = "setFloatingSpeciesInitConcentrations";
const char* SetFloatingSpeciesInitConcentrationsCodeGen::IndexArgName = "floatingSpeciesIndex";

SetFloatingSpeciesInitConcentrationsCodeGen::SetFloatingSpeciesInitConcentrationsCodeGen(
        const ModelGeneratorContext &mgc) :
        SetInitialValueCodeGenBase<SetFloatingSpeciesInitConcentrationsCodeGen, false>(mgc)
{
}

std::vector<std::pair<uint, std::string> > SetFloatingSpeciesInitConcentrationsCodeGen::getIds()
{
    return independentElements(dataSymbols, dataSymbols.getFloatingSpeciesIds());
}




const char* SetCompartmentInitVolumesCodeGen::FunctionName = "setCompartmentInitVolumes";
const char* SetCompartmentInitVolumesCodeGen::IndexArgName = "compartmentIndex";

SetCompartmentInitVolumesCodeGen::SetCompartmentInitVolumesCodeGen(
        const ModelGeneratorContext &mgc) :
        SetInitialValueCodeGenBase<SetCompartmentInitVolumesCodeGen, false>(mgc)
{
}

std::vector<std::pair<uint, std::string> > SetCompartmentInitVolumesCodeGen::getIds()
{
    return independentElements(dataSymbols, dataSymbols.getCompartmentIds());
}



} /* namespace rr */

