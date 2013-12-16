include(${CMAKE_CURRENT_SOURCE_DIR}/FindSWIG.cmake) # this is slightly modified FindSWIG.cmake file -  had to tune it to work with OSX

FIND_PACKAGE(SWIG REQUIRED)

INCLUDE(UseSWIG)

FIND_PACKAGE(PythonLibs)
FIND_PACKAGE(PythonInterp)
FIND_PACKAGE(NumPy)

MESSAGE ("THIS IS NUMPY_VERSION " ${NUMPY_VERSION})

MESSAGE ("THIS IS NUMPY_INCLUDE_DIRS " ${NUMPY_INCLUDE_DIRS})

MESSAGE ("THIS IS PYTHON_INCLUDE_PATH " ${PYTHON_INCLUDE_PATH})

INCLUDE_DIRECTORIES(${PYTHON_INCLUDE_PATH})
INCLUDE_DIRECTORIES(${CMAKE_CURRENT_SOURCE_DIR})
INCLUDE_DIRECTORIES(${CMAKE_BINARY_DIR}/include)
INCLUDE_DIRECTORIES(${NUMPY_INCLUDE_DIRS})
INCLUDE_DIRECTORIES(${RR_SOURCE_PATH}/third_party/rr-libstruct)



SET(PYINTERFACE_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/pyinterface)
SET(CMAKE_SWIG_FLAGS "")



IF(SWIG_FOUND)
    add_subdirectory(roadrunner)
ELSE(SWIG_FOUND)
    message("could not find SWIG in your system")
ENDIF(SWIG_FOUND)

if(WIN32)
    install(FILES install_roadrunner_win.py
        DESTINATION .    
        )
endif(WIN32)