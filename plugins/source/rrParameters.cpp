#pragma hdrstop
#include "rrLogger.h"
#include "rrParameters.h"

namespace rrp
{
using namespace rr;

Parameters::Parameters()
{}

Parameters::~Parameters()
{
    clear();
}

void Parameters::clear()
{
    for(int i = 0; i < mParas.size(); i++)
    {
        if(mParas[i].second == true)
        {
            delete mParas[i].first;
        }
    }
    mParas.clear();
}

void Parameters::add(PluginParameter* me, bool own)
{
    mParas.push_back( pair<PluginParameter*, bool>(me, own) );
}

StringList Parameters::asStringList() const
{
    StringList list;
    for(int i = 0; i < count(); i++)
    {
        list.add(mParas[i].first->getName());
    }
    return list;
}

const PluginParameter* Parameters::operator[](const int& i) const
{
    return mParas[i].first;
}

PluginParameter* Parameters::operator[](const int& i)
{
    return mParas[i].first;
}

u_int Parameters::count() const
{
    return mParas.size();
}

PluginParameter* Parameters::getParameter(const string& paraName)
{
    for(int i = 0; i < count(); i++)
    {
        if(paraName == mParas[i].first->getName())
        {
            return mParas[i].first;
        }
    }
    return NULL;
}

}