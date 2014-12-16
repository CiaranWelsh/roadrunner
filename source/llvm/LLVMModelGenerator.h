/*
 * LLVMModelGenerator.h
 *
 * Created on: Jun 3, 2013
 *
 * Author: Andy Somogyi,
 *     email decode: V1 = "."; V2 = "@"; V3 = V1;
 *     andy V1 somogyi V2 gmail V3 com
 */
#ifndef rrLLVMModelGeneratorH
#define rrLLVMModelGeneratorH

#include "ModelGenerator.h"
#include "LLVMCompiler.h"

#if (__cplusplus >= 201103L) || defined(_MSC_VER)
#include <tr1proxy/rr_memory.h>
#include "tr1proxy/rr_unordered_map.h"
#define cxx11_ns std
#else
#include <tr1proxy/rr_memory.h>
#include "tr1proxy/rr_unordered_map.h"
#define cxx11_ns std::tr1
#endif

namespace rrllvm
{

/**
 * General concepts:
 *
 * SBML defines chemical species.
 *
 * Floating Species: species whose value varies over time, i.e. they can 'float'
 * Boundary Species: boundary condition species, values are fixed to initial conditions.
 */
class RR_DECLSPEC LLVMModelGenerator: public rr::ModelGenerator
{
public:
    LLVMModelGenerator();
    virtual ~LLVMModelGenerator();

    /**
     * certain model generators, such as the compiler based ones
     * generate files such as shared libraries. This specifies the
     * location where they are stored.
     */
    virtual bool setTemporaryDirectory(const std::string& path);

    /**
     * certain model generators, such as the compiler based ones
     * generate files such as shared libraries. This specifies the
     * location where they are stored.
     */
    virtual std::string getTemporaryDirectory();

    /**
     * Create an executable model from an sbml string
     */
    virtual  rr::ExecutableModel *createModel(const std::string& sbml, uint options);


    /**
     * Get the compiler object that the model generator is using to
     * 'compile' sbml. Certain model generators may be interpreters, in this
     * case, the Compiler interface should still be sufficiently general to
     * manipulate interpreters as well.
     */
    virtual rr::Compiler *getCompiler();

    /**
     * No effect on LLVM generator.
     */
    virtual bool setCompiler(const std::string& compiler);


private:
    LLVMCompiler compiler;
};

} /* namespace rr */
#endif /* rrLLVMModelGeneratorH */
