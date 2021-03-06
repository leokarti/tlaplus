package org.lamport.tla.toolbox.spec;

import java.io.File;

import org.lamport.tla.toolbox.util.RCPNameToFileIStream;

import tla2sany.semantic.ModuleNode;

/**
 * Representation of a module
 * @author Simon Zambrovski
 * @version $Id$
 */
public class Module
{
    private File file;
    private ModuleNode node;
    private boolean isRoot = false;

    public Module(String absoluteFilename)
    {
        file = new File(absoluteFilename);
    }

    /**
     * Retrieves absolute path of the module file
     * 
     * @return path of the module file
     */
    public String getAbsolutePath()
    {
        if (file == null) 
        {
            return null;
        }
        return file.getAbsolutePath();
    }

    /**
     * Retrieves the file handle
     * 
     * @return the file
     */
    public File getFile()
    {
        return file;
    }

    /**
     * Retrieves the module name
     * @return the name of the module
     */
    public String getModuleName()
    {
        if (file == null) 
        {
            return null;
        }
        String filename = file.getName();
        if (filename.toLowerCase().indexOf(".tla") != -1)
        {
            filename = filename.substring(0, filename.indexOf(".tla"));
        }
        return filename;
    }

    /**
     * Retrieves the semantic node of the module (only available if the module has been parsed successfully)
     * 
     * @return the node
     */
    public ModuleNode getNode()
    {
        return node;
    }

    /**
     * Sets the semantic module node
     * 
     * @param node
     *            the node to set
     */
    public void setNode(ModuleNode node)
    {
        this.node = node;
    }

    /**
     * Determines if current module is a standard module <br>
     * TODO Fishy method. improve/unify it
     * 
     * @return true iff the absolute path of the module contains RCPNameToFileIStream.STANDARD_MODULES value
     */
    public boolean isStandardModule()
    {
        return (getAbsolutePath().indexOf(RCPNameToFileIStream.STANDARD_MODULES) != -1);
    }

    
    public boolean isRoot()
    {
        return isRoot;
    }
    
    public void setRoot(boolean isRoot)
    {
        this.isRoot = isRoot;
    }
    
    public void destroy()
    {
        this.file = null;
        this.node = null;
        this.isRoot = false;
    }
}
